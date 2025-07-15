<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/feedPageStyle.css" />
<script src="./js/feedPageJs.js"></script>
</head>
<body>
	<header id="header">
		<div class="top1">
			<div class="top_logo">
				<a href="#" class="logo" aria-label="홈으로"> <img
					src="../src/logo_mlp.png" alt="MLP 로고">
				</a>
			</div>
			<div class="searchBar">
				<input type="search" placeholder="관심있는 주제, 키워드로 검색해보세요!" />
				<button class="search_btn" aria-label="검색">🔍</button>
			</div>
			<div class="manageItem">
				<button class="add_feed_btn" aria-label="피드 작성">➕</button>
				<button class="alarm_btn" aria-label="알림">🔔</button>
				<button class="profile_btn" aria-label="프로필">
					<img src="../src/profile_basic.svg" alt="프로필 사진">
				</button>
			</div>
		</div>
		<nav class="cateList" aria-label="카테고리 메뉴">
			<button class="cateBtn" aria-haspopup="true" aria-expanded="false">
				🗒️ 카테고리</button>
			<ul class="category-menu">
				<li><a href="#">피드</a></li>
				<li><a href="#">지식콘텐츠</a></li>
				<li><a href="#">캠퍼스</a></li>
				<li><a href="#">나의학습</a></li>
			</ul>
		</nav>
	</header>

	<main id="body">
		<aside id="leftItem">
			<section class="myProfile" aria-label="내 프로필 정보">
				<div class="profileTop">
					<img src="../src/profile_basic.svg" alt="내 프로필 사진">
					<div class="myProfileInfo">
						<h3>${dto.memname }</h3>
						<p>${dto.memdepart }</p>
						<p>${dto.memgroup }</p>
					</div>
				</div>
				<div class="profileBottom">
					<div class="manageProfile">
						<span>팔로워 0 | 팔로잉 0</span>
						<button class="editProfile" aria-label="프로필 수정">프로필 수정</button>
					</div>
				</div>
			</section>

			<nav class="feedCategory" aria-label="피드 카테고리">
				<ul>
					<li>전체 피드</li>
					<li>📢 알려드립니다!</li>
					<li>우리회사 피드</li>
					<li>팔로잉 피드</li>
					<li>캠퍼스 피드</li>
					<li>내가 작성한 피드</li>
					<li>저장한 피드</li>
				</ul>
			</nav>

			<section class="friend" aria-label="친구 추천">
				<div class="friend_top">
					<strong>친구 추천</strong>
					<button aria-label="이전 친구">◀️</button>
					<button aria-label="다음 친구">▶️</button>
				</div>
				<div class="friend_bottom">
					<div class="addFriend" aria-label="추천 친구 1"></div>
					<div class="addFriend" aria-label="추천 친구 2"></div>
				</div>
			</section>
		</aside>

		<section id="rightItem">
			<div class="feedGroup">
				<div class="feedTop">
					<strong>전체 피드</strong>
					<button class="createFeed" aria-label="피드 작성">➕ 피드작성</button>
				</div>
				<div class="feedSearch">
					<div class="searchInput">
						<input type="search" placeholder="검색어를 입력해주세요!" />
						<button class="search_input_btn" aria-label="검색">🔍</button>
					</div>
					<div class="feedSort">
						<select name="orderFeed" aria-label="정렬 옵션">
							<option value="latest">최신순</option>
							<option value="manyView">조회순</option>
							<option value="good">좋아요순</option>
							<option value="comment">댓글순</option>
						</select>
					</div>
					<div class="feedView" role="group" aria-label="보기 모드">
						<button class="feedBasic" aria-label="기본 보기">📖</button>
						<button class="feedSummary" aria-label="요약 보기">📄</button>
						<button class="feedGallery" aria-label="갤러리 보기">🖼️</button>
					</div>
				</div>
				<div class="feedList">
					<c:forEach var="bDto" items="${list }">
						<table class="feedTable"
							style="border: solid 1px white; border-radius: 2.5%">
							<tr>
								<td>
									<p>
										${bDto.memname }
										<button onclick="location.href='feed?command=updateform&feedno=${bDto.feedno}'">📝</button>
									</p>
									<span>${bDto.memdepart } * ${bDto.memgroup }</span>
								</td>
							</tr>
							<tr>
								<td><span>${bDto.regdate }</span></td>
							</tr>
							<tr>
								<th>${bDto.feedtitle }</th>
							</tr>
							<tr>
								<td><textarea rows="20" cols="80" readonly="readonly">${bDto.feedcontent }</textarea>
								</td>
							</tr>
						</table>
						<hr>
					</c:forEach>
				</div>
			</div>
		</section>
	</main>
	<div class="pageController">
		<button id="bookMarkBtn" aria-label="북마크">🗃️</button>
		<button id="goTopBtn" aria-label="맨 위로">⬆️</button>
	</div>

	<!-- 프로필 수정 팝업 -->
	<div class="editProfilePopup" id="editProfilePopupId" role="dialog"
		aria-modal="true" aria-labelledby="editPro">
		<div class="editProfileContent">
			<form action="member" method="post">
				<input type="hidden" name="command" value="memupdate"> <input
					type="hidden" name="memno" value="${dto.memno }">
				<h1>프로필 수정</h1>

				<section id="editHeader">
					<div class="profile-pic-container">
						<img id="profilePreview" src="../src/profile_basic.svg"
							alt="프로필 사진"> <input type="file" name="profileImage"
							accept=".jpg,.jpeg,.png,.gif" title="클릭하여 사진을 선택하세요">
						<p class="file-note">jpg, png, gif | 최대 5MB</p>
					</div>
					<div class="profile-info">
						<input type="text" name="memname" value="${dto.memname}"
							placeholder="이름을 입력하세요"> <input type="text"
							name="memintro" placeholder="소개글을 입력하세요">
						<button type="button" class="keyword-btn">추천 키워드</button>
					</div>
				</section>

				<section id="editContent">
					<table>
						<tr>
							<th>부서</th>
							<td>${dto.memdepart}</td>
						</tr>
						<tr>
							<th>회사</th>
							<td>${dto.memgroup}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="mememail"
								value="${dto.mememail}" placeholder="example@company.com">
							</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="memphone"
								value="${dto.memphone}" placeholder="010-1234-5678"></td>
						</tr>
						<tr>
							<th>사번</th>
							<td>${dto.memno}</td>
						</tr>
						<tr>
							<th>비밀번호 변경</th>
							<td><input type="text" name="mempw" value="${dto.mempw}"
								placeholder="새 비밀번호 입력"></td>
						</tr>
					</table>
				</section>

				<div class="editBtns">
					<button id="cancelEditBtn" aria-label="취소" type="button">취소</button>
					<button id="saveEditBtn" aria-label="저장" type="submit">저장</button>
				</div>
			</form>
		</div>
	</div>

	<!-- 피드 작성 팝업 창 -->
	<div class="createFeedPopup" id="createFeedPopupId" role="dialog" aria-modal="true">
		<div class="createFeedContent">
			<form action="feed" method="post">
				<input type="hidden" name="command" value="insertFeed">
				<input type="hidden" name="memno" value="${dto.memno }">
				<input type="hidden" name="memgroup" value="${dto.memgroup }">
				<input type="hidden" name="memdepart" value="${dto.memdepart }">
				<input type="hidden" name="memname" value="${dto.memname }">
				<h1>피드 작성</h1>
				<table>
					<tr>
						<td><input type="text" name="feedtitle" placeholder="피드 제목을 입력하세요" required></td>
					</tr>
					<tr>
						<td><input type="text" name="keyword" placeholder="키워드를 선택하세요"></td>
					</tr>
					<tr>
						<td><textarea name="feedcontent" rows="5" placeholder="내용을 입력하세요" required></textarea></td>
					</tr>
					<tr>
						<td>
							<div class="editBtns">
								<button type="button" id="cancelFeedBtn">취소</button>
								<button type="submit" id="submitFeedBtn">등록</button>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>