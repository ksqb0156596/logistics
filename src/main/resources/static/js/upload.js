
function upload(){
    $("#excelUpload").click();
}
$("#excelUpload").ajaxfileupload({
    action: '/upload/upload',
    valid_extensions: ['xls','xlsx'],
    onComplete: function(data){
        if(data.code == '0000'){
            layer.msg("上传成功",{icon:1});
                $("#showData").bootstrapTable({
                    data: data.result,
                    striped: true,
                    columns: [{
                        field: "orderNo",
                        title: "订单号",
                    },{
                        field: "consignee",
                        title: "收件人"
                    },{
                        field: "telphone",
                        title: "手机号"
                    },{
                        field: "address",
                        title: "地址"
                    },{
                        field: "categoryInfo.expressName",
                        title: "快递名称",
                        formatter: function(value,d, index, field){
                            return d.categoryInfo.expressName
                        }
                    },{
                        field: "categoryInfo.expressNumber",
                        title: "快递单号",
                        formatter: function(value,d, index, field){
                            return d.categoryInfo.expressNumber
                        }
                    },{
                        field: "categoryInfo.categoryName",
                        title: "物品名称",
                        formatter: function(value,d, index, field){
                            return d.categoryInfo.categoryName
                        }

                    },{
                        field: "categoryInfo.categoryCount",
                        title: "物品数量",
                        formatter: function(value,d, index, field){
                            return d.categoryInfo.categoryCount
                        }
                    },{
                        field: "categoryInfo.remark",
                        title: "备注",
                        formatter: function(value,d, index, field){
                            return d.categoryInfo.remark
                        }
                    },{
                        field: "categoryInfo.sendDate",
                        title: "发货日期",
                        formatter: function(value,d, index, field){
                            var date = new Date(d.categoryInfo.sendDate);
                            var month = date.getMonth() + 1;
                            return date.getFullYear() + "/" +  (month < 10 ? ("0" +month) : month)
                                + "/" + (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate())
                        }
                    }
                    ]
                })
        }else{
            layer.msg("上传失败，" + data.message,{icon:2});
        }
    }
});