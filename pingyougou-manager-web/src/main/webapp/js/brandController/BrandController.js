//控制层要对服务层进行引用
app.controller("brandController", function ($scope,$http,brandService,$controller) {//注意这里要加入$controller,就好比依赖注入;

    $controller('baseController',{$scope:$scope});

    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
    }
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
    /*保存修改的数据
    * */
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null) {
            object = brandService.update($scope.entity);
        } else {
            object = brandService.update($scope.entity);
        }
        object.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }

    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        )
    }
    $scope.delete = function () {
        brandService.delete($scope.selectIDs).success(
            function (response) {
                if (response.success) {
                    //将列表刷新;
                    $scope.reloadList();
                }
            }
        )
    }
    $scope.searchEntity = {};//确保一开始不为null;
    //根据条件进行查询;
    $scope.search = function (page, rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;//总记录数
                $scope.list = response.rows;//给列表变量赋值
            }
        );
    }
})
