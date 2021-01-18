function RestUtil() {
    this.postData = function (url, data, success, error) {
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: success,
            error: error
        })
    }

    this.getData = function (url, success, error) {
        $.ajax({
            url: url,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: success,
            error: error
        })
    }
}
