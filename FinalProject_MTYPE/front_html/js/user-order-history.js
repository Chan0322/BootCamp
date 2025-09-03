document.querySelectorAll(".order_item").forEach((item) => {
  const status = item.querySelector(".item_status");
  const btn_ordered_list = item.querySelector(".item_btn");

  if (!status || !btn_ordered_list) return;

  const statusText = status.textContent.trim();

  //버튼에 저장된 텍스트 초기화
  btn_ordered_list.innerHTML = "";

  // 운송장번호
  const createDeliveryNo = (num) => {
    const delivery = document.createElement("div");
    delivery.className = "delivery_no";
    delivery.textContent = `${num}`;
    return delivery;
  };

  if (statusText == "상품준비중") {
    const cancelBtn = document.createElement("button");
    cancelBtn.textContent = "주문 취소";
    btn_ordered_list.appendChild(cancelBtn);
  } else if (statusText == "배송완료") {
    const returnBtn = document.createElement("button");
    returnBtn.textContent = "반품신청";
    btn_ordered_list.appendChild(returnBtn);
    //운송장
    status.appendChild(createDeliveryNo("1111-2222-3333"));
  } else {
    //버튼 없는 경우
    status.appendChild(createDeliveryNo("2222-3333-4567"));
  }
});
