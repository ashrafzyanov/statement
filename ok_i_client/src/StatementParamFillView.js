import React, { useState, useEffect }from 'react';
import { useParams } from 'react-router-dom';
export default function StatementParamFillView() {

    const [items, setItems] = useState([]);
    const [fields, setFields] = useState([]);
    let { id } = useParams();

    useEffect(() => {
        fetch("/server/api/statement/" + id)
            .then(res => res.json())
            .then(data => {
                setItems(data)
                setFields(data.fields.map(item => {
                    return {
                        code: item.code,
                        description: item.description,
                        type: item.type
                    }
                }));
            })
    }, [id])
    
    return (
      <div>
        <h3>Name: {items.name}</h3>
        <div> FIELDS </div>
        <ul>
            {fields.map(item => (
                    <li key={item.id}>
                        {item.name} - {item.description} - {item.type}
                    </li>
                ))}
        </ul>
      </div>
    );
    
}