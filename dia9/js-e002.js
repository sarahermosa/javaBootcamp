
var sumaCuadratica = (a,b,c) => {
    let discriminante = Math.pow(b, 2) - (4 * a * c);

    if (discriminante < 0){
        return "La ecuacion no tiene soluciones reales";
    } else {
        let raizCuadratica1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        let raizCuadratica2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return ["Raiz (+) = " +raizCuadratica1, "Raiz (-) = "+ raizCuadratica2];
    }
}

console.log(sumaCuadratica(1,-8,12))
 

