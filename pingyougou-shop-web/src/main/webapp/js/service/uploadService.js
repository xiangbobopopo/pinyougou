app.service('uploadService', function($http){
    var formdata= new FormData();
    formdata.append("file", file.file[0]);//文件上传框的name;
    return $http({
        url:'../upload.do',
        method:'post',
        data:formdata,
        headers:{'content-type':undefined},
        transformRequest:angular.identity
    });
});