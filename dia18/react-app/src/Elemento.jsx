import React, { useState } from 'react';
import SubElemento from './SubElemento';

const Elemento = ({ elemento, id, selected, onElementoClick }) => {
  const [expanded, setExpanded] = useState(false);

  const hasSubElements = elemento.subElements && elemento.subElements.length > 0;

  const onElementoClickHandler = () => {
    onElementoClick(id);
    if (hasSubElements) {
      setExpanded(!expanded);
    }
  };

  return (
    <div className="elemento" onClick={onElementoClickHandler}>
      {elemento.element}
      {hasSubElements && (
        <div className="sub-elementos-container">
          {expanded && elemento.subElements.map((subElemento) => (
            <SubElemento key={subElemento} subElemento={subElemento} />
          ))}
        </div>
      )}
    </div>
  );
};

export default Elemento;
