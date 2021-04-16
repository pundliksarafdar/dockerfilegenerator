$(document).ready(function () {
    $(document).find("#generateDockerFIle").bind("click", generateDockerFile);
    $(document).find("#buildAndDeployDocker").bind("click", buildAndDeployDocker);
    $(document).find("#generateDockerCompose").bind("click", generateDockerComposeFile);
    checkPrerequisite();
    attachBuildScriptListenr();
});

function attachBuildScriptListenr(){
    var url = location.origin;
    url = url.replace("http://","ws://");
    var ws = new WebSocket(url+"/build_messages");
    ws.onmessage = function(message){
        $("#dockerBuildCommandResponse").append(message.data+"\n");
    }
}

function buildAndDeployDocker() {
    $("#dockerBuildCommandResponse").empty();
    var dockerFileContent = $(document).find("#dockerFileContent").val();
    var imageName = $(document).find("#buildImageName").val();
    var tagName = $(document).find("#buildImageTag").val();
    var dataToPost = {dockerFileContent:dockerFileContent, imageName:imageName, tag:tagName};
    var rUtil = new RestUtil();
    rUtil.postData("/build", JSON.stringify(dataToPost), function (data) {
        console.log("Success", data);
    }, function () {
        console.log("Error");
    });
}

function generateDockerFile() {
    $("#dockerBuildCommandResponse").empty();
    var data = $(document).find("form#generationForm").serializeArray();
    var dataToPost = {};
    for (var d in data) {
        if (data[d].value === "on") {
            dataToPost[data[d].name] = true;
        } else {
            dataToPost[data[d].name] = data[d].value;
        }
    }
    console.log(dataToPost);
    var rUtil = new RestUtil();
    rUtil.postData("/generator", JSON.stringify(dataToPost), function (data) {
        console.log("Success", data);
        $("#dockerFileContent").val(data.dockerFile);
    }, function () {
        console.log("Error");
    });
}

function generateDockerComposeFile() {
    $("#dockerBuildCommandResponse").empty();
    var data = $(document).find("form#generationForm").serializeArray();
    var dataToPost = {};
    for (var d in data) {
        if (data[d].value === "on") {
            dataToPost[data[d].name] = true;
        } else {
            dataToPost[data[d].name] = data[d].value;
        }
    }
    console.log(dataToPost);
    var rUtil = new RestUtil();
    rUtil.postData("/generator_compose", JSON.stringify(dataToPost), function (data) {
        console.log("Success", data);
        $("#dockerFileContent").val(data.dockerFile);
    }, function () {
        console.log("Error");
    });
}

function checkPrerequisite() {
    var rUtil = new RestUtil();
    rUtil.getData("/prerequisite", function (data) {
        console.log(data);
        if (!data.docker) {
            $("#prerequisiteAlert").append("Docker is not installed please install docker on server").show();
        }

        if (!data.git) {
            $("#prerequisiteAlert").append("Git is not installed please install git on server").show();
        }

        if (data.docker && data.git) {
            $("#prerequisiteAlert").hide();
        }
    }, function () {

    })
}
