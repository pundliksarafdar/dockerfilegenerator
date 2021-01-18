
$(document).ready(function(){
   $(document).find("#generateDockerFIle").bind("click",generateDockerFile)
    checkPrerequisite();
});

function generateDockerFile() {
    var data = $(document).find("form#generationForm").serializeArray();
    var dataToPost = {};
    for (var d in data){
        if (data[d].value === "on"){
            dataToPost[data[d].name] = true;
        }else{
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

function checkPrerequisite(){
    var rUtil = new RestUtil();
    rUtil.getData("/prerequisite",function (data) {
           console.log(data);
           if (!data.docker){
               $("#prerequisiteAlert").append("Docker is not installed please install docker on server").show();
           }

           if(!data.git){
               $("#prerequisiteAlert").append("Git is not installed please install git on server").show();
           }

           if(data.docker && data.git){
               $("#prerequisiteAlert").hide();
           }
    },function () {

    })
}
