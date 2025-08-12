function Footer() {
  const name = "lcj";
  const no = 10;
  const obj = { a: 1, b: 2 };
  return (
    <>
      <footer>
        <h1>footer!! {name}</h1>
        <h3>{no}</h3>
        <h3>{no + 5 + "ddd"}</h3>
        <h3>{no % 2 == 0 ? "짝수" : "홀수"}</h3>
        <h3>{obj.a + ":" + obj.b}</h3>
        <hr />
      </footer>
      <div>div</div>
    </>
  );
}

export default Footer;
