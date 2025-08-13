// parameter 받기
import { useParams } from "react-router-dom";

const Detail = () => {
  const params = useParams();
  console.log(params);
  //http://localhost:5173/detail/kim => params에 {id: 'kim'}로 받아진다.

  return <h1>{params.id}의 Detail page</h1>;
};

export default Detail;
