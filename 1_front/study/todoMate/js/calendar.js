window.onload = function(){
    const currentDate = document.getElementById("current_date"); // 선택 날짜 출력
    const monthDay = document.getElementById("day");             // 월별 일자 출력
    const prev = document.querySelector("#prevMonth");           // 지난달   
    const next = document.querySelector("#nextMonth");           // 다음달

    // 기존 코드
    // let month = new Date().getMonth();
    // let year = new Date().getFullYear();
    // 이렇게 작성하면 Date 객체를 두 번 생성하므로 성능 비효율적

    console.log(prev); // null인지 확인
    console.log(next);

    // 수정 코드
    let date = new Date();
    let month = date.getMonth();
    let year = date.getFullYear();

    function createCalendar(){
        monthDay.innerHTML = "";
        currentDate.textContent = `${year}년 ${month+1}월`;

        let firstDay = new Date(year, month, 1).getDay(); // 현재 날짜의 월에 해당하는 1일의 요일.
        // firstDay=0 일요일 1=월 2=화......
        let lastDay = new Date(year, month+1, 0).getDate(); // 다음 달의 0일 => 이번 달의 마지막 일이 반환

        //오늘날짜 정보(달력에 표시하기 위함)
        let now = new Date();
        let nowYear = now.getFullYear();
        let nowMonth = now.getMonth();
        let nowDay = now.getDate();

        //테이블에 날짜 입력해 달력 생성
        let row = "<tr>";
        // 이번 달의 1일 전에 있는 테이블 비우기.
        for(let i=0; i<firstDay; i++){
            row += "<td></td>";
        }
        // 마지막 일까지 테이블 채우기.
        for(let i=1; i<=lastDay; i++){
            let idVal = i;  // td에 부여하기 위한 id
            let classVal = (year==nowYear && month==nowMonth && i==nowDay) ? "now":""; // 오늘 날짜에 클래스 부여.
            row += `<td id="${idVal}" class="${classVal}" onclick="selectedDay(${i})">${i}</td>`;  // 달력 생성 시 매일 id 부여
            // 토요일이 되면 일요일부터 테이블 다음 줄에.
            if((i+firstDay)%7 == 0){
                row += "</tr><tr>";
            }
        }
        row += "</tr>";
        monthDay.innerHTML = row;
    }

    prev.addEventListener("click", ()=>{
        month--;
        if(month<0){
            month=11;
            year--;
        }
        createCalendar();
    });

    next.addEventListener("click", ()=>{
        month++;
        if(month>11){
            month=0;
            year++;
        }
        createCalendar();
    });

    createCalendar();
}

// 날짜 선택 시 클릭 이벤트 처리
function selectedDay(i){
    // 이미 선택된 날짜가 있다면, 이전 선택 제거.
    let preSelected = document.querySelector(".selected");
    if(preSelected) {
        preSelected.classList.remove("selected");      // 이미 생성되어 있던 selected 클래스 제거.
    }
    // 이전 선택된 날짜가 없다면, 선택
    let selDay = document.getElementById(i);
    if(selDay){
        selDay.classList.add("selected");   // 선택된 날짜에 selected 클래스 추가
    }
}

let cntTodo = 0;
// 할일 추가 기능
function addTodo(clickedBtn){
    let todoUl = document.createElement("ul");
    // todoUl.append(document.createElement("input").placeholder = "할 일 입력");   // 이렇게 작성 시 입력받을 수 없어진다.
    let input = document.createElement("input");
    input.placeholder = "할 일 입력";
    input.id = "todoId";// + ++cntTodo;    // 할 일 목록 삭제를 위해 input 생성 시, id 부여

    // input 생성 시, 각 할 일 목록 삭제가 가능하도록 버튼 추가.
    let delTodoBtn = document.createElement("button");
    delTodoBtn.textContent = "❌";
    delTodoBtn.addEventListener("click", function(){
        todoUl.remove();
        //--cntTodo;
    });

    // blur 이벤트는, 해당 태그가 포커스를 잃었을 경우 발생.
    input.addEventListener("blur", function(){
        if(input.value == ""){
            todoUl.remove();
        }
    });

    todoUl.append(input, delTodoBtn);
    console.log(clickedBtn.parentNode.parentNode);
    clickedBtn.parentNode.parentNode.append(todoUl);

    input.focus(); // 생성된 input 태그에 포커스
}

// 카테고리 관리 메뉴 클릭 이벤트
function popUp(page){
    // // window.open(page.href, "_blank ", "width=800px, height=600px");
    // let createCate = document.createElement("div");
    // let input = document.createElement("input");
    // input.placeholder("카테고리 이름 입력");
    // createCate.append(input);
    // page.parentNode.parentNode.append(createCate);
    const body2Div = document.getElementById("body_2_1");
    const newCate = document.createElement("div");
    //newCate.className = "newCategory";
    newCate.innerHTML = `
    <div class="newCategory">
        <span>🔒</span><span class="cateName">새 카테고리</span>
        <button onclick="addTodo(this)">➕</button>
        <button onclick="editCateName(this)">✏️</button>
        <button onclick="delCate(this)">❌</button>
    </div>`;
    body2Div.appendChild(newCate);
}

// 카테고리 관리 선택 시 드롭다운 메뉴
function todoManage(){
    let drop = document.getElementById("todoDrop");
    if(drop.style.display=="none"){
        drop.style.display="block";
    }else{
        drop.style.display="none";
    }
}

// 카테고리 삭제
function deleteCate(catego){
    const newCatego = document.querySelectorAll(".newCategory");
    for(let i=0; i<newCatego.length; i++){
        newCatego[i].remove();
    }
}

function delCate(delCateBtn){
    const categoryDiv = delCateBtn.parentNode.parentNode;
    categoryDiv.remove();
}

// 카테고리 이름 수정
function editCateName(editCateN){
    const categoryDiv = editCateN.parentNode;
    // 이미 카테고리 이름 편집 중인 경우
    if(categoryDiv.querySelector("input.editCateInput")){
        return;
    }

    const cateNameSpan = categoryDiv.querySelector(".cateName");
    // 현재 카테고리의 이름을 수정할 수 있게 input 생성
    const input = document.createElement("input");
    input.type = "text";
    input.className = "editCateInput";
    input.value = cateNameSpan.textContent;
    input.placeholder = "변경할 이름 입력";

    // 현재 카테고리 이름이 담긴 span 태그를 input 태그로 변경 => 이름 변경이 가능!
    function editComplete(){
        const newName = input.value || "새 카테고리";
        cateNameSpan.textContent = newName;
        categoryDiv.replaceChild(cateNameSpan, input);
    }
    // input 포커스 해제 또는 엔터 누르면 입력
    input.addEventListener("blur", editComplete);
    // keydown 이벤트는 눌려진 키보드 가져옴!
    input.addEventListener("keydown", function(e){
        if(e.key == "Enter"){
            editComplete();
        }
    });
    // 다시 span 태그로 변경경
    categoryDiv.replaceChild(input, cateNameSpan);
    input.focus();
}