<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ajax的省市县展示</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/show/showProvince",
                type:"GET",
                dataType:"json",
                success:function (provinces) {
                    for(var i =0;i<provinces.length;i++){
                        var option = $("<option  value="+provinces[i].code+">"+provinces[i].name+"</option>");
                        $("#province").append(option);
                    }
                }
            });
            $.ajax({
                url:"${pageContext.request.contextPath}/show/showCity",
                type:"GET",
                data:"city.provinceid="+110000,
                dataType:"json",
                success:function (citys){
                    for(var i =0;i<citys.length;i++){
                        var option = $("<option  value="+citys[i].code+">"+citys[i].name+"</option>");
                        $("#city").append(option);
                    }
                }
            });

            $.ajax({
                url:"${pageContext.request.contextPath}/show/showArea",
                type:"GET",
                data:"area.cityid="+110100,
                dataType:"json",
                success:function (areas) {
                    for (var i = 0; i < areas.length; i++) {
                        var option = $("<option  value=" + areas[i].code + ">" + areas[i].name + "</option>");
                        $("#area").append(option);

                    }
                }
            });
            //市的下拉框
            $("#province").change(function () {
                var code = $("#province option:selected").val();
                //发送ajax
                $.ajax({
                    url:"${pageContext.request.contextPath}/show/showCity",
                    type:"GET",
                    data:"city.provinceid="+code,
                    dataType:"json",
                    success:function (citys) {
                        //清空
                        $("#city").empty();
                        for(var i =0;i<citys.length;i++){
                            var option = $("<option  value="+citys[i].code+">"+citys[i].name+"</option>");
                            $("#city").append(option);
                        }
                        //选完省后展示第一个市和对应的区
                        $.ajax({
                            url:"${pageContext.request.contextPath}/show/showArea",
                            type:"GET",
                            data:"area.cityid="+citys[0].code,
                            dataType:"json",
                            success:function (areas) {
                                //清空
                                $("#area").empty();
                                for (var i =0;i<areas.length;i++){
                                    var option = $("<option  value=" + areas[i].code + ">" + areas[i].name + "</option>");
                                    $("#area").append(option);
                                }

                            }
                        })
                    }
                });
        });
            //县区的下拉框
            $("#city").change(function () {
                var code = $("#city option:selected").val();
                console.log(code);
                //发送ajax
                $.ajax({
                    url:"${pageContext.request.contextPath}/show/showArea",
                    type:"GET",
                    data:"area.cityid="+code,
                    dataType:"json",
                    success:function (areas) {
                        //清空
                        $("#area").empty();
                        for (var i = 0; i < areas.length; i++) {
                            var option = $("<option  value=" + areas[i].code + ">" + areas[i].name + "</option>");
                            $("#area").append(option);

                        }
                    }
                });
            });
    });
    </script>
    <style>
        select{
            width: 140px;
        }
    </style>
</head>
<body>


    省: <select name="" id="province" ></select>
    市: <select name="" id="city"></select>
    区: <select name="" id="area"></select>

</body>
</html>