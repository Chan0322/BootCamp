const Btn2 = ({ text, size = 10 }) => {
  // {prop, props} => 구조분해할당
  const onClickBtn = (e) => {
    console.log(text);
    console.log(size);
    console.log(e);
  };

  return (
    <>
      <button onClick={onClickBtn} style={{ fontSize: size }}>
        {text}
      </button>
    </>
  );
};

export default Btn2;
