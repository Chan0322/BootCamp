//1. import
import { useState } from "react";

const Body = ({ st, test }) => {
  return (
    <div>
      <h1>
        Body입니다. state값: {st}, test값: {test}
      </h1>
    </div>
  );
};

function App2() {
  //2. state 생성
  const [state, setState] = useState(0);

  const [test, setTest] = useState("TEST");

  let cnt = 0;
  return (
    <>
      <h1>state:{state}</h1>
      <h1>var:{cnt}</h1>
      <Body st={state} test={test} />
      <hr></hr>

      <button
        onClick={() => {
          setState(state + 1);
          cnt = cnt + 1;
          console.log("cnt: " + cnt);
        }}
      >
        클릭
      </button>
    </>
  );
}

export default App2;
