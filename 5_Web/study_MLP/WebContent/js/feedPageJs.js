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

	const editPopup = document.getElementById('editFeedPopup');
	const cancelEditBtn = document.getElementById('cancelEditFeed');
	const editButtons = document.querySelectorAll('.editFeedBtn');

	// 1) 수정 버튼 클릭 → 팝업 띄우기 + 값 채우기
	editButtons.forEach(btn => {
		btn.addEventListener('click', () => {
			// data-* 속성에서 값 가져오기
			const data = btn.dataset;
			document.getElementById('edit-feedno').value = data.feedno;
			document.getElementById('edit-memno').value = data.memno;
			document.getElementById('edit-memgroup').value = data.memgroup;
			document.getElementById('edit-memdepart').value = data.memdepart;
			document.getElementById('edit-memname').value = data.memname;
			document.getElementById('edit-regdate').value = data.regdate;
			document.getElementById('edit-feedtitle').value = data.feedtitle;
			document.getElementById('edit-feedcontent').value = data.feedcontent;

			// 팝업 보이기
			editPopup.style.display = 'flex';
		});
	});

	// 2) 취소 버튼 → 팝업 닫기
	cancelEditBtn.addEventListener('click', () => {
		editPopup.style.display = 'none';
	});

	// (선택) 3) 모달 바깥 클릭 시 닫기
	editPopup.addEventListener('click', e => {
		if (e.target === editPopup) {
			editPopup.style.display = 'none';
		}
	});

});