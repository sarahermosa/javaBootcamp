import React, { useState } from 'react';
import Elemento from './Elemento';
import './App.css'

const App = () => {
  const [selectedElementId, setSelectedElementId] = useState(null);

  const elementos = [
    {
      "element": "Data Portal"
    }, 
    {
      "element": "About Portal"
    },
    {
      "element": "Contact"
    },
    {
      "element": "Home",
      "subElements": [
        "Investor or regulator",
        "First thing to know",
        "Critical Inflection Point",
        "Uneven Distribution",
        "Risks may Filter UP"
      ]
    }
  ];

  const onElementoClick = (id) => {
    if (selectedElementId === id) {
      setSelectedElementId(null);
    } else {
      setSelectedElementId(id);
    }
  };

  return (
    <div>
      {elementos.map((elemento) => (
        <Elemento
          key={elemento.element}
          elemento={elemento}
          id={elementos.indexOf(elemento)}
          selected={selectedElementId === elementos.indexOf(elemento)}
          onElementoClick={onElementoClick}
        />
      ))}
    </div>
  );
};

export default App;
