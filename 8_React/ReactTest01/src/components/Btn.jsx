const Btn = (props) => {
  console.log(props);
  return (
    <>
      <button style={{ fontSize: props.size }}>{props.text}</button>
    </>
  );
};

export default Btn;
