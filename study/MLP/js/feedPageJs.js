document.addEventListener('DOMContentLoaded', function(){   // html 로드 후 실행
    const upBtn = document.getElementById('goTopBtn');

    upBtn.addEventListener('click', function(){
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

    const newFeedBtn = document.querySelector('.createFeed');
    const feedList = document.querySelector('.feedList');

    newFeedBtn.addEventListener('click', function(){
        const newFeedHtml = `
            <div class="feedContent">
                <img src="../src/feedSample1.png" alt="New Feed">
            </div>
        `;

        // 피드 추가
        feedList.insertAdjacentHTML('beforeend', newFeedHtml);
    });
});