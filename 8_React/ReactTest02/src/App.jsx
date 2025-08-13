import Home from "./pages/Home";
import List from "./pages/List";
import Detail from "./pages/Detail";
import Error from "./pages/Error";

import { Routes, Route } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

function App() {
  const navi = useNavigate();
  function onClickBtn() {
    // 페이지 이동시키는 함수 활용
    navi("/list");
  }

  return (
    <>
      <button onClick={onClickBtn}>클릭</button>
      <a href="/list">리스트</a>
      <div>
        <Link to={"/"}>Home</Link> &nbsp;
        <Link to={"/list"}>List</Link> &nbsp;
        <Link to={"/detail/2"}>Detail</Link>
      </div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/list" element={<List />} />
        <Route path="/detail/:id" element={<Detail />} />
        <Route path="*" element={<Error />} />
        {/* path="*" : 와일드카드 */}
      </Routes>
    </>
  );
}

export default App;
