const input_fields = {
    numerodocumento: /^\d+-\d$/
};

const validate = (field, regex) => {
    const inputValue = field.value;
    const isValidInput = regex.test(inputValue);
    if (!isValidInput) {
        field.classList.add('invalid');
    } else {
        field.classList.remove('invalid');
    }
};

document.getElementById('inputTipoDocumento').addEventListener('change', function() {
    const selectedValue = this.value;
    const numerodocumento = document.getElementById('numerodocumento');
    if (selectedValue === '1') {
        numerodocumento.addEventListener('keypress', function(event) {
            const inputValue = event.key;
            const valueAfterHyphen = this.value.split('-')[1];
            if (!/\d|-/.test(inputValue) || (valueAfterHyphen && valueAfterHyphen.length >= 1 && inputValue !== '-')) {
                event.preventDefault();
            }
        });
    } else {
        numerodocumento.classList.remove('valid', 'invalid');
        numerodocumento.removeEventListener('keypress', function() {});
    }
});
