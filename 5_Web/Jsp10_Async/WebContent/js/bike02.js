$(function(){
	parseJson();
});

function parseJson(){
	$.getJSON("json/bike.json", function(data){
		//console.log(data);
		//stringify - 스트링 값으로 넘겨줌
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			data:{"obj":JSON.stringify(data)},
			success:function(){
				
			},
			error:function(){
				alert("data 저장 실패ㅜㅜ");
			}
		});
	});
}