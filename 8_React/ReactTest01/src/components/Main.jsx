import "./m.css";

const Main = () => {
  const obj = {
    a: "lcj",
    b: false,
  };

  //return <>{obj.b ? <div>true</div> : <div>false</div>}</>;
  if (obj.b) {
    return (
      <div
        style={{
          backgroundColor: "red",
          borderBottom: "10px solid blue",
        }}
      >
        참
      </div>
    );
  } else {
    return <div className="test">거짓</div>;
  }
};

export default Main;
