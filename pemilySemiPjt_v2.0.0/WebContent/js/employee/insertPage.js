$(document).ready(function() {
    //여기 아래 부분
	 $('.summernote').summernote({		//모든 textarea에 클래스로 서머노트 적용
	       height: 300,                 // 에디터 높이
	       minHeight: null,             // 최소 높이
	       maxHeight: null,             // 최대 높이
	       focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
	       lang: "ko-KR",					// 한글 설정
	       placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
	       toolbar: [
			    // [groupName, [list of button]]
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert',['picture','link','video']],
			    ['view', ['fullscreen', 'help']]
			  ],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
			//콜백함수
			callbacks: {
			    onImageUpload: function(files, editor, welEditable) {
		            for(var i = files.length - 1; i >= 0; i--) {
		            	sendFile(files[i], this);
		            }
			    }
			}              
	 });
	 //카테고리가 선택될(change) 때마다 동작 이벤트
	 $('#menuSelect').change(function(){
	     const forms = $('form');			//모든 form태그 가져오기
	     const optionVal = $(this).val(); 	//선택된 option의 value
	     for(var i=0;i<forms.length;i++){
	         if(optionVal == forms.eq(i).attr('id')){//option의 value와 form의 id가 동일하면 from 보여주기
	             hideFrm();					//페이지 로드 시 form 전부 숨기는 함수
	             $('#kindChoice').val('0');	//카테고리가 바뀔때마다 기존에 선택된 상위분류 초기화(default)
	             defaultValue(); 			//카테고리가 바뀔때마다 기존에 선택/입력된 동물 세부정보 초기화
	             hideKinds();				//카테고리가 바뀔때마다 기존에 나타난 하위분류 숨기는 함수
	             forms.eq(i).show();		//바뀐 카테고리의 form 보여주기
	         }
	     }
	 });
	 //공지사항중 직원/회원(select)이 선택될 때마다(change) 동작 이벤트
	 $('#noticeChoice').change(function(){
	 	const optionVal = $(this).val();	//선택된 공지(직원 : 1 / 회원 : 2)의 값을 hidden(noticeCom)에 대입하기위한 option의 value
	 	let noticeCom = $('#noticeCom');	//input[hidden]의 noticeCom요소 가져오기
	 	noticeCom.val(optionVal);			//선택된 값을 hidden의 vlaue에 대입
	 });
	 //등록하려는 동물과를 선택 시 선택된 select박스 보여주기 동작 이벤트
	 $('#kindChoice').change(function(){
	 	defaultValue();
	 	showKind($(this).val());			//select된 option의 value 가져와 반환
	 });
	 //동물과 > 동물 종의 선택될때 동작
	 $('.kinds').change(function(){
	 	$('#incaAn').val($(this).val());
	 	//showAnimalWrap();					//동물 종 선택 시 세부정보, 등록/취소 영역 보여주기
	 });
	 //동물 성별 선택 시 input값에 선택 값 넣어주는 함수
	 $('#incaGenderSel').change(function(){
	 	$('#incaGender').val($(this).val());
	 });
	 //동물 지점 선택 시 input값에 선택 값 넣어주는 함수
	 $('#incaStoreSel').change(function(){
	 	$('#incaStore').val($(this).val());
	 });
	 //상품 분류 선택 시 input값에 선택 값 넣어주는 함수
	 $('#inProKind').change(function(){
	 	const inProSn = $('#inProSn');
		inProSn.val($(this).val());
	 });
	 //동물 수정 시 건상 상태 select값 변경시 hidden 에 넣어주기
	 $('#incaConditionSel').change(function(){
	 	const incaCondition = $('#incaCondition');
	 	incaCondition.val($(this).val());	 	
	 });
	 //동물 수정 시 지점 select값 변경시 hidden 에 넣어주기
	 $('#incaStoreSel').change(function(){
	 	const incaStore = $('#incaStore');
	 	incaStore.val($(this).val());
	 });
	 //동물 분양비 를 한화 단위로 변경하는 함수
	 $("#incaPriceFake").keyup(function(){
	 	if($(this).val().length != 0){
	 		$(this).css('text-align','right');
	 	}else{
	 		$(this).css('text-align','left');	
	 	}
		//입력될 때마다 변하는 자리수에 ','를 제거(uncomma)하고 새로운 자리에 생성(comma)한다. 
	    $(this).val(comma(uncomma($(this).val())));		//uncomma에 값을 넘겨 기존에 있던 콤마를 제거하고 리턴된 값을 comma에 전달해 새로운 자리에 콤마를 생성하는 코드임
	   	incaPriceReal($(this).val());
	 });
	 $("#incaPriceFake").focus(function(){
	 	if($(this).val().length != 0){
	 		$(this).css('text-align','right');
	 	}else{
	 		$(this).css('text-align','left');	
	 	}
		//입력될 때마다 변하는 자리수에 ','를 제거(uncomma)하고 새로운 자리에 생성(comma)한다. 
	    $(this).val(comma(uncomma($(this).val())));		//uncomma에 값을 넘겨 기존에 있던 콤마를 제거하고 리턴된 값을 comma에 전달해 새로운 자리에 콤마를 생성하는 코드임
	   	incaPriceReal($(this).val());
	 });
	 //상품 가격을 한화 1,000단위로 comma추가하는 함수
	 $("#inProPriceFake").keyup(function(){
	 	if($(this).val().length != 0){
	 		$(this).css('text-align','right');
	 	}else{
	 		$(this).css('text-align','left');	
	 	}
		//입력될 때마다 변하는 자리수에 ','를 제거(uncomma)하고 새로운 자리에 생성(comma)한다. 
	    $(this).val(comma(uncomma($(this).val())));		//uncomma에 값을 넘겨 기존에 있던 콤마를 제거하고 리턴된 값을 comma에 전달해 새로운 자리에 콤마를 생성하는 코드임
	   	inProPriceReal($(this).val());
	 });
	 $("#caModifyPrice").keyup(function(){
	 	if($(this).val().length != 0){
	 		$(this).css('text-align','right');
	 	}else{
	 		$(this).css('text-align','left');	
	 	}
		//입력될 때마다 변하는 자리수에 ','를 제거(uncomma)하고 새로운 자리에 생성(comma)한다. 
	    $(this).val(comma(uncomma($(this).val())));		//uncomma에 값을 넘겨 기존에 있던 콤마를 제거하고 리턴된 값을 comma에 전달해 새로운 자리에 콤마를 생성하는 코드임
	   	inProPriceReal($(this).val());
	 });
	 
	 //콤마찍기(입력할 때마다 자리수가 변함)
	 function comma(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	 }
	 //콤마풀기(입력할 때마다 자리수가 변함)
     function uncomma(str) {
     	str = String(str);
        return str.replace(/[^\d]+/g, '');
     }
     //동물 등록 시 개월 수 입력 시 숫자만 입력될 수 있게 제어하는 함수
     $('#incaMonth').keypress(function(){
     	//keyCode(ACSII코드)목록에 기재되어있는 숫자(48~57)만 입력됨
     	if(event.keyCode<48 || event.keyCode>57){
     		//이벤트의 조작을 실행하지 않는다 > false
        	event.returnValue=false;
        }
     });
     //상품 등록 시 수량 input에 숫자만 입력 하게 제어하는 함수
     $('#inProAmount').keypress(function(){
     	//keyCode(ACSII코드)목록에 기재되어있는 숫자(48~57)만 입력됨
     	if(event.keyCode<48 || event.keyCode>57){
     		//이벤트의 조작을 실행하지 않는다 > false
        	event.returnValue=false;
        }
     });
     //동물 사진이 등록될 때마다 label>img에 경로를 넣어 보여줄 함수
     $('#incaPic').change(function(){
     	loadImg(document.getElementById('incaPic'));		//input[type=file] 요소 자신을 이미지 미리보기 함수에 전달
     });
     //상품 사진이 등록될 때마다 label > img에 경로를 넣어 보여줄 함수
     $('#inProPic').change(function(){
     	loadImg(document.getElementById('inProPic'));		//파일이 선택되면 자기사신을 loadImg 함수의 매개변수로 전달
     });
     //상품 수량 입력이 끝나면 오른쪽으로 보이기(1자라도 미 입력 시 placeholder 왼쪽)
     $('#inProAmount').change(function(){
     	if($(this).val().length == 0){
     		$(this).css('text-align','left');
     	}else{
     		$(this).css('text-align','right');
     	}
     });
     
	 //공지사항 등록버튼 클릭 시 빈/선택안된 값 체크하는 함수
	 $('#noticeBtn').click(function(){
	 	const noticeCom = $('#noticeCom').val();		//직원/회원 select값
	 	const title = $('#noticeTitle').val();			//제목 값
	 	//const content = $('#noticeContent').val();		//textarea는 html()로 값을 호출하는게 정상이지만 서머노트 에디터 적용값을 가져오려면 val()를 호출해야함
	 	const content = $('#noticeContent').summernote('code');	
		if(noticeCom == '0'){
			alert('등록할 공지를 선택하세요.');
			return;
		}else if(title == ''){
			alert('제목을 입력하세요');
			return;
		}else if(content == ''){
			alert('내용을 입력하세요');
			return;
		}
		$('#noticeFrm').submit();						//정상적인 값이 입력되었을 때 submit
	 });
	 //동물 등록 시 유효성 검사 후 결과에 따른 동작 함수
	 $('#incaBtn').click(function(){
		let reg = /^[가-힣]{1,5}$/;							//동물 이름이 제어하는 이름양식인지 판별하는 정규식 표현
		const incaAn = $('#incaAn').val();					//동물 종
	 	const incaName = $('#incaName').val();				//입력된 동물 이름
		let incaPrice = $('#incaPrice').val().length;		//동물 분양가의 입력된 길이
		const incaMonth = Number($('#incaMonth').val());	//동물 개월 수
		const incaGender = $('#incaGender').val();			//동물 성별
		const incaStore = $('#incaStore').val();			//동물 등록 지점
		const incaPic = $('#incaPic').val();				//동물 등록 사진
		const incaCondition = $('#incaCondition').val();	//동물 건강(검사)
		if(incaAn == '0'){
			alert('동물 종을 선택하세요');
			return;
		}else if(!reg.test(incaName)){
			alert('동물 이름을 최소 1자 ~ 최대 5자 까지 입력하세요.');
			return;
		}else if(incaPrice < 1){
			alert('동물 분양가는 최소 1자 이상 입력하세요.');
			return;
		}else if(incaMonth < 2){
			alert('우리는 2개월이 안된 동물은 등록할 수 없습니다.');
			return;
		}else if(incaGender == '0'){
			alert('동물 성별을 선택하세요.');
			return;
		}else if(incaStore == '0'){
			alert('등록할 지점을 선택하세요.');
			return;
		}else if(incaPic == ''){
			alert('동물 사진을 올려주세요.');
			return;
		}
	 	console.log('모든 값이 정상일 때');
	 	console.log(incaAn);			//종 
	 	console.log(incaName);			//이름
	 	console.log($('#incaPrice').val());				//분양가
	 	console.log(incaMonth);			//개월
	 	console.log(incaGender);		//성별
	 	console.log(incaStore);			//지점
	 	console.log(incaCondition);		//상태
	 	console.log(incaPic);			//등록 사진
	 	$('#incaFrm').submit();			//입력 값 모두 정상범위 일때 submit
	 });
	 //상품 재고 등록 시 유효성 검사, 빈값 체크
	 $('#inProBtn').click(function(){
	 	let reg = /^[a-zA-Z0-9가-힣]+$/;
		const inProName = $('#inProName').val();		//상품이름
		const inProSn = $('#inProSn').val();			//상품구분
		const inProAmount = $('#inProAmount').val();	//상풍수량
		const inProPrice = $('#inProPrice').val();		//상풍가격
		const inProPic = $('#inProPic').val();			//상품 등록사진
		if(!(reg.test(inProName) || inProName != '')){
			alert('상품 이름을 입력하세요.');
			return;
		}else if(inProSn == '0'){
			alert('상품 분류를 선택하세요.');
			return;
		}else if(inProAmount < '1'){
			alert('상품 수량을 입력하세요.');
			return;
		}else if(inProPrice < '1'){
			alert('상품 가격을 입력하세요.');
			return;
		}else if(inProPic == ''){
			alert('상품 사진을 등록하세요.');
			return;	 	
		}
		console.log('정상적으로 원하는 유효한 값이 입력된 경우');
		console.log(inProName);
		console.log(inProSn);
		console.log(inProAmount);
		console.log(inProPrice);
		console.log(inProPic);
		$('#inProFrm').submit();		//정상인경우 서버로 전송
	 });
});
///////////////////////////////////////////////////////////
// 이부분 부터는 페이지 로드 되기전부터 함수가 먼저 선언되기때문에 여기서 호출해도 동작하지 않습니다.
// 함수만 만들고 onload에서 호출하면 ok
function hideFrm(){ 					//페이지 로드 시 또는 카테고리 변경 시
     const forms = $('form');			//form전부 가져오기
     for(var i=0;i<forms.length;i++){
         forms.eq(i).hide();			//form전부 숨기기
     }	    			
};
function hideKinds(){					//페이지 로드 시 또는 분류 변경 시
	const kinds = $('.kinds');			//하위분류(select) 가져오기
	for(var i=0;i<kinds.length;i++){
		kinds.eq(i).hide();				//하위분류 전부 숨기기
	};
};

function defaultValue(){				//카테고리 또는 동물과 선택 시 기존에 입력되었던 동물의 세부정보 초기화
	incaInputsDelete();
	inProInputsDelete();
};
function incaInputsDelete(){			//동물 등록 form의 input,select,img 삭제 함수
	$('#incaPic').val('');				//동물 등록 사진 파일 값 초기화
	$('#incaPicImg').remove();			//등록된 동물 사진 미리보기 삭제
	$('#incaName').val('');				//동물 이름 초기화
	$('#incaPriceFake').val('');		//동물 분양가 초기화(화면상에보이는 input > form으로 보내는 값 아님)
	$('#incaPrice').val('');			//동물 분양가 초기화
	$('#incaMonth').val('');			//동물 개월 수 초기화
	$('#incaAn').val('0');				//동물 종 초기화
	$('#incaGenderSel').val('0');		//동물 성별 초기화
	$('#incaStoreSel').val('0');		//동물 등록 지점 초기화
};
function inProInputsDelete(){			//상품등록 form의 input,select,img 삭제 함수
	$('#inProPic').val('');				//상품 등록 사진파일 초기화
	$('#inProName').val('');			//상품 이름 초기화
	$('#inProKind').val('0');			//상품 분류 select 초기화
	$('#inProSn').val('');				//상품 분류 input값 초기화
	$('#inProAmount').val('');			//상품 수량 초기화
	$('#inProPrice').val('');			//상품 가격 초기화
	$('#inProPriceFake').val('');		//상품 가격 초기화(화면에 보여지는 input)
	$('#inProPicImg').remove();			//상품 이미지 삭제
}
function showKind(val){
	hideKinds();						//모든 하위분류 숨기기
	$(`#${val}`).val('0');				//상위 분류의 선택option이 바뀔때마다 기존에 선택했던 하위분류 초기화
	$(`#${val}`).show();				//하위 분류 보여주기
};
function incaMonthChk(){
	const incaMonth = $('#incaMonth').val();
	if(incaMonth<2){
		alert('우리는 생후 2개월 이하인 동물은 등록하지 않습니다!');
		return false;
	}
};
function loadImg(input){ 						//input > #incaPic(파일input)
	console.log(input.files);					//input file에서 선택한 파일을 배열로 가지고옴
	console.log(input.id);
	const inputId = input.id;
	if(input.files.length != 0){				//첨부파일이 있는 경우
		var reader = new FileReader();			//첨부파일을 읽어올 객체(자바스크립트)
		reader.readAsDataURL(input.files[0]);	//해당 파일의 경로를 읽어옴 > 읽어오는데 시간이 좀 걸림
		//경로를 다 읽어오면 실행할 함수 지정
		reader.onload=function(e){				//매개변수 e 는 reader가 파일의 경로를 읽어온 후 반환
			let img = $("<img id='"+inputId+"Img"+"' src='"+e.target.result+"'>");	//파일 이미지 태그 경로 넣어주며 생성
			$(`#${inputId}+label`).html(img);						//선택한 파일 경로가 적용된 이미지 태그를 나타낼 요소에 추가
			//$(`#${inputId}+Img`).attr("src",e.target.result);
		}
	}else{										//첨부파일이 없는 경우
		console.log(`#${inputId}Img`);
		$(`#${inputId}Img`).remove();					//기존에 있던 img 삭제
	}
};
function incaPriceReal(value){					//hidden인 분양비의 값 변경
	const fake = value;							//화면상에 보여지는 분양비
	const real = $('#incaPrice');				//실제 전송하게 될 분양비
	real.val(fake.split(',').join(""));			//1,000단위로 comma가 붙은 값에서 ','를 제거하고 실제 분양비 input에 값 대입
};
function inProPriceReal(value){
	const fake = value;							//화면상에 보여지는 분양비
	const real = $('#inProPrice');				//실제 전송하게 될 분양비
	real.val(fake.split(',').join(""));			//1,000단위로 comma가 붙은 값에서 ','를 제거하고 실제 분양비 input에 값 대입	
};
function sendFile(file, el) {			//해당 편집기에 이미지를 드래그해서 추가했을때 sendFile()이 동작하고 매개변수로 this를 받아왔기 때문에 class로 여러개의 편집기를 사용해도 연동은 없다.
	var formData = new FormData();		//form에서의 이미지(data)를 보내기 위한 객체
  	formData.append('file', file);
  	$.ajax({
    	data: formData,
    	type: "POST",
    	url: '/imageUpload',
    	cache: false,
    	contentType: false,
    	enctype: 'multipart/formaDta',
    	processData: false,
    	success: function(imgSrc) {
      		$(el).summernote('editor.insertImage', imgSrc);
    	}
  	});
}