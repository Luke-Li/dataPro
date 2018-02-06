/**
 * Created by a88u on 2016/10/12.
 */
menuList.report.isActive=true;
menuList.report.showChild=true;
menuList.report.childMenu.traderReport.isActive=true;

var traderReportButtons=[];

// 初始化各条件
function initButtons(){
    for(var i=0;i<traderReportButtons.length;i++){
        traderReportButtons[i].className="btn btn-default buttons-html5";
    }
    if(traderReportButtons.length>0){
        traderReportButtons[traderReportButtons.length-1].className="btn btn-default buttons-html5 type-select";
    }
}

initButtons();
var v_traderReportModel=new Vue({
    el:"#v-traderReportModel",
    data:{
        traderSelections:traderSelectionsList, // 所有研究报告类型
        traderList:traderList, // 研究报告类型大类
        pitem:traderList[0].children, // 研究报告子类
        traderTags:[], // 当前选中类别
        traderResult:[],
        showConditions:false,
        showConditionTypes:false,
        traderParamTags: {
            keyContent: {key: "keyContent", text: "", isSelected: false}, // 关键字
            typeList: []
        },
        traderIsEnd:false,
        traderResultPage:0,
        traderResultTypes:"",
        traderFilterKey:"",
    },
    ready:function(){

    },
    methods:{
        openPdfOnline:function(path){
            openFilesOnline(path);
        },
        pageControlFilter:function(value){
            console.log(value,this.traderResultPage);
            if(value==0){
                return this.traderResultPage!=0;
            }else{
                return !this.traderIsEnd;
            }
        },
        changeResultPage:function(type,value){
            if(value==0){ // 上一页
                this.traderResultPage--;
            }else{ // 下一页
                this.traderResultPage++;
            }
            getSubResultPage(this.traderFilterKey,this.traderResultPage,this.traderResultTypes);
        },
        seleceTypeList:function(item,event){
            console.log(item.text);
            this.pitem=item.children;
            for(var i=0;i<this.traderList.length;i++){
                var oi=this.traderList[i];
                oi.isSelected=false;
            }
            item.isSelected=true;
        },
        setTraderSelection:function(item){
            var isSelect=item.isSelected;
            item.isSelected=!isSelect;
            if(isSelect){ // 选中--非选中
                var temp=[];
                for(var i=0;i<this.traderTags.length;i++){
                    var ot=this.traderTags[i];
                    if(ot.value!=item.value){
                        temp.push({text:ot.text,value:ot.value});
                    }
                }
                this.traderTags=temp;
            }else{ // 非选中--选中
                this.traderTags.push({text:item.text,value:item.value});
            }
        },
        setTraderTagClose:function(value){ // 选中--非选中
            var temp=[];
            for(var i=0;i<this.traderTags.length;i++){
                var ot=this.traderTags[i];
                if(ot.value!=value){
                    temp.push({text:ot.text,value:ot.value});
                }
            }
            this.traderTags=temp;
            for(var i=0;i<this.traderSelections.length;i++){
                if(this.traderSelections[i].value==value){
                    this.traderSelections[i].isSelected=false;
                    $("#traderSelect_"+value).removeClass("fa-check-square").addClass("fa fa-square-o");
                }
            }
        }
    },
    filters:{
        currentPageFilter:function(value){
            var p=value+1;
            return "第"+p+"页";
        },
        traderSelectFilter:function(value){
            return "traderSelect_"+value;
        },
        checkEmptyFilter:function(value){
            var result=false;
            if(value&&value.length>0){
                result=true;
            }
            return result;
        },
        showRaderReportTypeFilter:function(value){
            return traderItems["T"+value];
        },
        checkIfSelectFilter:function(value){
            for(var i=0;i<this.pitem.length;i++){
                var ic=this.pitem[i];
                if(value==ic.value){
                    return true;
                }
            }
            return false;
        }
    }
});

getSubResultPage("",0,"");

function getSubResultPage(key,page,types){
    console.log(types);

    v_traderReportModel.$data.traderParamTags.keyContent.text="关键字: "+key;
    v_traderReportModel.$data.traderParamTags.keyContent.isSelected=(key!="");

    var flag=false,splittypes=[];
    v_traderReportModel.$data.traderParamTags.typeList=[];
    if(types.length>0) {
        splittypes=types.split(",");
        console.log(splittypes);
        if (splittypes.length > 0 && splittypes[0] != "0") {
            for (var i = 0; i < splittypes.length; i++) {
                var item = splittypes[i];
                v_traderReportModel.$data.traderParamTags.typeList.push({"text": traderItems["T" + item],"value":item});
            }
        }
    }
    v_traderReportModel.$data.showConditionTypes=(v_traderReportModel.$data.traderParamTags.typeList.length>0&&v_traderReportModel.$data.traderParamTags.typeList.length!=traderItems.length);
    if(v_traderReportModel.$data.traderParamTags.keyContent.isSelected||v_traderReportModel.$data.showConditionTypes){
        v_traderReportModel.$data.showConditions=true;
    }else{
        v_traderReportModel.$data.showConditions=false;
    }

    var from=page*commonPageNum.traderReports;
    $.ajax({
        url: commonUrls.reportUrl,              //请求地址
        type: "POST",                            //请求方式
        data: { //请求参数
            key:key,
            from:from,
            count:commonPageNum.traderReports,
            type:'trader',
            filter:types
        },
        dataType: "json",
        success: function (res) {
            if(res.status=='failure'){
                //goToLoginout();
                console.log("failure",res.message);
            }else if(res.status=="timeout"){
                console.log("timeout");
                goToNotlogon();
            }else if(res.status=='success') {
                //console.log("send ajax success");
                var response = res;
                updateTraderTable(response.trader_report_list);
            }
        },
        fail: function (status) {
            console.error("error. status=", status);
        },
        statusCode: {
            404: function() {
                goTo404();
            },
            500:function(){
                goTo500();
            }
        }
    });
}

function updateTraderTable(data){
    $('#traderResult_table').DataTable().destroy();
    v_traderReportModel.$data.traderResult=data;
    console.log("show",v_traderReportModel.$data.traderResult.length);
    if(data.length==0){
        v_traderReportModel.$data.traderIsEnd=true;
    }else{
        v_traderReportModel.$data.traderIsEnd=false;
    }
    v_traderReportModel.$nextTick(function () {
        // var options={
        //     dom:'<"html5buttons"B><"searchToolbar dataTables_filter">tp',
        //     initComplete:function(){
        //         $("div.searchToolbar").html('<label>搜索:<input id="ivsFilterInput" type="search" onkeypress="doDataSearch(event,this.value)" class="form-control input-sm" placeholder="请输入查询..." value="' + v_traderReportModel.$data.traderFilterKey + '"></label>');
        //     }
        // }
        // bindDataTable("traderResult_table",-1,"研究报告查询结果", traderReportButtons,options);
        bindSimpleDataTable("traderResult_table",-1);
    });
}

function bothCheck(){
    var cvcontent=$(".type-check-list");
    var par=cvcontent.find("li").find("a").find("i");
    par.removeClass("fa-square-o").addClass("fa-check-square");

    for(var i=0;i<v_traderReportModel.$data.traderSelections.length;i++){
        v_traderReportModel.$data.traderSelections[i].isSelected=false;
    }
    v_traderReportModel.$data.traderTags=[];
}

function doDataSearch(event,value){
    var event = event || window.event; // 为了兼容firefox没有全局event对象
    if (event.keyCode == 13) { // 回车搜索
        var key = value;
        console.log("search key=#", key, "#");
        bothCheck();
        v_traderReportModel.$data.traderFilterKey=key;
        v_traderReportModel.$data.traderResultPage=0;
        v_traderReportModel.$data.traderResultTypes="";
        getSubResultPage(key,0,"");
    }
}
function doSearch() {
    var key=$("#ivsFilterInput").val();
    console.log(key);
    v_traderReportModel.$data.traderFilterKey=key;
    v_traderReportModel.$data.traderResultPage=0;
    v_traderReportModel.$data.traderResultTypes="";
    bothCheck();
    getSubResultPage(key,0,"");
}
function showTypeFilter(type){
    v_traderReportModel.$data.traderTags=[];

    for(var i=0;i<v_traderReportModel.$data.traderSelections.length;i++){
        var item=v_traderReportModel.$data.traderSelections[i];
        var flag=false;
        for(var t=0;t<v_traderReportModel.$data.traderParamTags.typeList.length;t++){
            if(v_traderReportModel.$data.traderParamTags.typeList[t].value==item.value){
                flag=true;
                break;
            }
        }
        if(flag){
            console.log(item.text);
            item.isSelected=true;
            v_traderReportModel.$data.traderTags.push({text:item.text,value:item.value});
            $("#traderSelect_"+item.value).removeClass("fa-square-o").addClass("fa-check-square");// 勾选
        }else{
            item.isSelected=false;
            $("#traderSelect_"+item.value).addClass("fa-square-o").removeClass("fa-check-square");// 不勾选
        }
    }
    $("#traderSelect").show(500);
}

function doTypeSelect(){
    var subTypes=[];
    var subType="";
    for(var i=0;i<v_traderReportModel.$data.traderTags.length;i++){
        var item=v_traderReportModel.$data.traderTags[i];
        subTypes.push(item.value);
    }
    subType=subTypes.join(",");
    console.log(subType);
    v_traderReportModel.$data.traderResultTypes=subType;
    v_traderReportModel.$data.traderResultPage=0;
    closeSelect();
    getSubResultPage(v_traderReportModel.$data.traderFilterKey,0,subType);
}

function closeSelect(){
    $("#traderSelect").hide(500);
}




