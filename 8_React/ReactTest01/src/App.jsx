import { useState } from "react";
import "./App.css";
import Footer from "./components/Footer.jsx";

//function Header() {}
// html을 리턴하는 함수 => 컴포넌트
// 컴포넌트의 함수 이름은 첫 글자 대문자.
const Header = () => {
  return (
    <header>
      <h1>Header..</h1>
    </header>
  );
};

function App() {
  return (
    <>
      <Header />
      <Footer />
    </>
  );
}

export default App;
