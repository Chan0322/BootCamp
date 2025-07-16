// 피드 정렬

function onSortChange() {
	const order = document.getElementById('orderFeed').value;
	const keyword = document.getElementById('searchInput').value.trim();
	let url = `feed?command=list&order=${encodeURIComponent(order)}`;
	if (keyword) {
		url += `&keyword=${encodeURIComponent(keyword)}`;
	}
	window.location.href = url;
}

function onSearch() {
	// 정렬 유지하며 검색
	onSortChange();
}

document.addEventListener('DOMContentLoaded', function() {   // html 로드 후 실행
	const upBtn = document.getElementById('goTopBtn');

	upBtn.addEventListener('click', function() {
		// 바디 부분 스크롤
		window.scrollTo({
			top: 0,
			behavior: 'smooth'
		});

		// 내부 좌측 스크롤
		const leftScroll = document.getElementById('leftItem');
		leftScroll.scrollTo({
			top: 0,
			behavior: 'smooth'
		});
	});

	/*
		const newFeedBtn = document.querySelector('.createFeed');
		const feedList = document.querySelector('.feedList');
	
		newFeedBtn.addEventListener('click', function() {
			const newFeedHtml = `
				<div class="feedContent">
					<img src="../src/feedSample1.png" alt="New Feed">
				</div>
			`;
	
			// 피드 추가 -> 기존 목록 끝에 새 피드를 넣는다.
			feedList.insertAdjacentHTML('beforeend', newFeedHtml);
		});
	*/
	// 프로필 수정 팝업
	const editBtn = document.querySelector('.editProfile');
	const popup = document.getElementById('editProfilePopupId');
	const cancelBtn = document.getElementById('cancelEditBtn');
	const saveBtn = document.getElementById('saveEditBtn');

	// 팝업 열기
	editBtn.addEventListener('click', function() {
		popup.classList.add('show');
	});
	// 닫기
	cancelBtn.addEventListener('click', function() {
		popup.classList.remove('show');
	});
	// 저장 버튼
	saveBtn.addEventListener('click', function() {
		alert('프로필이 저장되었습니다!');
		popup.classList.remove('show');
	});

	// 피드 작성 팝업
	const feedPopup = document.getElementById('createFeedPopupId');
	const createFeedBtn = document.querySelector('.createFeed');
	const cancelFeedBtn = document.getElementById('cancelFeedBtn');

	// 열기
	createFeedBtn.addEventListener('click', function() {
		feedPopup.classList.add('show');
	});

	// 닫기
	cancelFeedBtn.addEventListener('click', function() {
		feedPopup.classList.remove('show');
	});


	// 피드 정렬 => 페이지 로드 시 order 파라미터 읽고 반영
	// 피드 검색 추가
	const params = new URLSearchParams(window.location.search);

	const currentOrder = params.get('order') || 'latest';
	document.getElementById('orderFeed').value = currentOrder;

	const currentKeyword = params.get('keyword') || '';
	document.getElementById('searchInput').value = currentKeyword;

});