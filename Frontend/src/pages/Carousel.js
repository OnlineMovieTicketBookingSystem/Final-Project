import { useEffect, useState } from 'react';
import axios from 'axios';
export default function Carouselslide() {
  const [halls,sethalls]=useState([])
  const [date,setdate]=useState('')
  const [movieName,setmovieName]=useState('')
  const [slot,setslot]=useState(0)
  const [hallId,sethallId]=useState(0)
  const [data,setData]=useState([])
  
  
  return (
    <>
    <div className='mt-5'>
      <div className="d-block w-100"
         style={{height:"500px",backgroundImage:"url('header.jpg')",backgroundSize:"100% 100%"}}>
           <form className="d-block mx-auto" style={{width:"80%",position:"absolute",top:"44%",left:"50%",transform:"translate(-50%,-50%)"}}>
             <div className='row'>
                <div className='col-sm-3'>
                <select className="form-control me-2" value={slot} onChange={e=>setslot(e.target.value)}>
                  
                </select>
                </div>
               <div className='col-sm-2'>
                <select className="form-control me-2" value={hallId} onChange={e=>sethallId(e.target.value)}>
                    <option value="">Select Hall</option>
                    {halls.map(x=>(
                    <option value={x.hallId}>{x.hallDesc}</option>
                    ))}
                </select>
                </div>
                <div className='col-sm-3'>
                <input type='search' placeholder='Movie name here' className="form-control me-2" value={movieName} onChange={e=>setmovieName(e.target.value)}/>
                </div>
                <div className='col-sm-3'>
                <input type="date" className='form-control me-2' value={date} onChange={e=>setdate(e.target.value)} />
                </div>                
                <div className='col-sm-1'>
                <button onClick={handleSearch} className="btn btn-warning bg-gradient text-white" type="submit"><i className="fa fa-search"></i></button>
                </div>
                </div>
            </form>
         </div>
    </div>
    <SearchResult data={data} />
    </>
  );
}
