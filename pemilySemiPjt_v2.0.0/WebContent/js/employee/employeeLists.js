$(function(){
	//'수정'클릭 시 수정 페이지로 이동
	$('.modifyBtn').click(function(){
		const hiddenModiChk = $('.hiddenModiChk').val();
		const num = $(this).val();
		if(hiddenModiChk == 1){
			location.href="/noticeEmpModifyMove?noticeNo="+num;
		}else if(hiddenModiChk == 2){
			location.href="/incaModifyMove?incaNo="+num;			
		}else if(hiddenModiChk == 3){
			//location.href="/inProModifyMove?inProNo="+num;
			modifyOn($(this));					
		}
	});
	// '완료' 클릭 시 모달 동작
	$('.completeBtn').click(function(){
		const hiddenModiChk = $('.hiddenModiChk').val();
		const num = $(this).val();
		const inProPrice = $(this).parent().prev().prev().children().eq(3).val();
		const inProAmount = $(this).parent().prev().children().eq(2).val();
		console.log(inProPrice);
		console.log(inProAmount);
		console.log(num);
		console.log(hiddenModiChk);
		if(hiddenModiChk == 1){		//직원 공지 수정
			noticeModifyAjax(hiddenModiChk);
		}else if(hiddenModiChk == 2){	//반려동물 등록 수정
			incaModifyAjax(hiddenModiChk);
		}else if(hiddenModiChk == 3){	//물품 재고 수정
			inProModifyAjax(num,inProPrice,inProAmount,hiddenModiChk);
		}
	});
	//모달 '삭제'클릭 시 삭제하기
	$('.deleteBtn').click(function(){
		$('.comment-box').html('정말 삭제하시겠습니까?');
		$('.ynCheck').css('display','flex');
		$('.okBtn').val($(this).val());
	});
	
	//모달 삭제 예/아니오 중 '예' 클릭 시 동작
	$('.okBtn').click(function(){
		const hiddenDelChk = $('.hiddenDelChk').val();
		console.log(hiddenDelChk);
		if(hiddenDelChk == 11){
			const noticeNo = $(this).val();
			console.log(noticeNo);
			noticeEmpDelete(noticeNo,hiddenDelChk);	//직원 공지 삭제 ajax 함수
		}else if(hiddenDelChk == 22){			
			const incaNo= $(this).val();
			console.log(incaNo);
			incaDelete(incaNo,hiddenDelChk);			//반려동물 등록 목록 삭제 ajax 함수
		}else if(hiddenDelChk == 33){
			const inProNo = $(this).val();
			inProDelete(inProNo,hiddenDelChk);			//물품 등록 삭제 ajax 함수
		}
		$('.ynCheck').css('display','none');
		$('.ynCheck').find('comment-box').html('');
	});
	//모달의 '아니오' 버튼 클릭 시
	$('.noBtn').click(function(){
		$('.ynCheck').css('display','none');
		$('.ynCheck').find('comment-box').html('');
	});
	//모달의 '확인'버튼 클릭 시 동작
	$('.confirmBtn').click(function(){
		$('.confirmChk').find('comment-box').html('');
		$('.confirmChk').css('display','none');

		const confirm = $(this).val();
		console.log($(this).val());
		if(confirm == 1){
			location.href='/noticeEmpView?noticeNo='+$('#noticeNo').val();
		}else if(confirm == 2){
			location.href='/caList?reqPage=1';
		}else if(confirm == 3){
			location.href='/productList?reqPage=1';
		}else if(confirm == 11){
			location.href='/noticeEmpList?reqPage=1&noticeCom=1';
		}else if(confirm == 22){
			location.href='/caList?reqPage=1';
		}else if(confirm == 33){
			location.href='/productList?reqPage=1';	
		}
	});
	$('.goBackBtn').click(function(){
		window.history.back();
	});
	$('.cancelBtn').click(function(){
		const hiddenModiChk = $('.hiddenModiChk').val();
		if(hiddenModiChk != 3){
			window.history.back();
			return;
		}
		reBackBtn($(this));
	});
	
});
//직원 공지 수정 완료 클릭 시
function noticeModifyAjax(hiddenModiChk){
	const noticeContent = $('#modifyContentNote').val();
	const noticeNo = $('#noticeNo').val();
	const noticeWriter = $('#noticeWriter').val();
	const noticeTitle = $('#noticeTitle').val();
	console.log('test');
	console.log(hiddenModiChk);
	$.ajax({
		url : "/nModifyFrm",
		data : {noticeContent : noticeContent, noticeNo : noticeNo, noticeWriter : noticeWriter, noticeTitle : noticeTitle},
		type : "post",
		success : function(data){
			const text = data>0?"수정 완료!" : "다시 시도해주세요ㅠ";
			$('.confirmChk').find('.comment-box').html(text);
			$('.confirmChk').css('display','flex');
			$('.confirmBtn').val(hiddenModiChk);
		}
	});
}
//반려동물 등록 수정 '완료' 클릭 시
function incaModifyAjax(hiddenModiChk){
	const incaNo = $('#incaNo').val();
	const incaPrice	= $('#incaPrice').val();
	const incaCondition = $('#incaCondition').val();
	const incaStore = $('#incaStore').val();
	$.ajax({
		url : "/incaModifyFrm",
		data : {incaNo : incaNo, incaPrice : incaPrice, incaCondition : incaCondition, incaStore : incaStore},
		type : "post",
		success : function(data){
			const text = data>0?"수정 완료!" : "다시 시도해주세요ㅠ";
			$('.confirmChk').find('.comment-box').html(text);
			$('.confirmChk').css('display','flex');
			$('.confirmBtn').val(hiddenModiChk);
		}
	});
}
function inProModifyAjax(num,price,amount,hiddenModiChk){
	const inProNo = num;
	const inProPrice	= price;
	const inProAmount = amount;
	$.ajax({
		url : "/inProModifyFrm",
		data : {inProNo : inProNo, inProPrice : inProPrice, inProAmount : inProAmount},
		type : "post",
		success : function(data){
			const text = data>0?"수정 완료!" : "다시 시도해주세요ㅠ";
			$('.confirmChk').find('.comment-box').html(text);
			$('.confirmChk').css('display','flex');
			$('.confirmBtn').val(hiddenModiChk);
		}
	});
}
function noticeEmpDelete(val,hiddenDelChk){
	console.log(val);
	$.ajax({
		url : "/noticeEmpDelete",
		data : {noticeNo : val},
		type : "get",
		success : function(data){
			const text = Number(data) > 0?"삭제되었습니다.":"다시 시도해주세요.";
			$('.confirmChk').find('.comment-box').html(text);
			$('.confirmChk').css('display','flex');
			$('.confirmBtn').val(hiddenDelChk);
		}
	});
}
//직원 공지사항 ajax로 delete
function incaDelete(val,hiddenDelChk){
//	const incaNo = val;
	console.log(val);
	$.ajax({
		url : "/incaDelete",
		data : {incaNo : val},
		type : "get",
		success : function(data){
			const text = Number(data) > 0?"삭제되었습니다.":"다시 시도해주세요.";
			$('.confirmChk').find('.comment-box').html(text);
			$('.confirmChk').css('display','flex');
			$('.confirmBtn').val(hiddenDelChk);
		}
	});
	
}
function inProDelete(val,hiddenDelChk){
	$.ajax({
		url : "/inProDelete",
		data : {inProNo : val},
		type : "get",
		success : function(data){
			const text = Number(data) > 0?"삭제되었습니다.":"다시 시도해주세요.";
			$('.confirmChk').find('.comment-box').html(text);
			$('.confirmChk').css('display','flex');
			$('.confirmBtn').val(hiddenDelChk);
		}
	});
}
//물품 수정 클릭 시 동작
function modifyOn(ele){
	// 가격
	const price = ele.parent().prev().prev().children().html();
	// 수량
	const amount = ele.parent().prev().children().html();
	//수정 클릭 시 수정/삭제 hide
	ele.hide();									//수정 버튼
	ele.parent().next().children().hide();		//삭제 버튼
	
	//input show
	ele.parent().prev().prev().children().eq(0).hide();
	ele.parent().prev().prev().children().eq(1).hide();
	ele.parent().prev().prev().children().eq(2).show().css('width','100px');

	ele.parent().prev().children().eq(0).hide();
	ele.parent().prev().children().eq(1).hide();
	ele.parent().prev().children().eq(2).show().css('width','100px');
	
	
	
	//완료/취소 버튼 show
	ele.next().show();
	ele.parent().next().children().eq(1).show();
	console.log(ele);
	console.log(price);
	console.log(amount);
}
function reBackBtn(ele){
	ele.hide();			//취소버튼
	ele.prev().show();	//삭제버튼
	ele.parent().prev().children().eq(0).show();
	ele.parent().prev().children().eq(1).hide();
	
	//input show
	ele.parent().prev().prev().prev().children().eq(0).show();
	ele.parent().prev().prev().prev().children().eq(1).show();
	ele.parent().prev().prev().prev().children().eq(2).hide();
	
	let price = ele.parent().prev().prev().prev().children().eq(0).html();
	ele.parent().prev().prev().prev().children().eq(2).val(price);

	ele.parent().prev().prev().children().eq(0).show();
	ele.parent().prev().prev().children().eq(1).show();
	ele.parent().prev().prev().children().eq(2).hide();
	
	let amount = ele.parent().prev().prev().children().eq(0).html();
	ele.parent().prev().prev().children().eq(2).val(amount);
}

function confirmModalOn(){
	$('.confirm').css('display','flex');
	
}
function confirmModalOff(){
	$('.confirm').css('display','none');
}