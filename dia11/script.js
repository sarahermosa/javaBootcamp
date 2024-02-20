$(document).ready(function(){
    $('#accordionContainer').collapse({
        toggle: false 
    });

    $('.ver-archivos').click(function() {
        // Obtener el valor de la versión de la fila seleccionada
        var version = $(this).closest('tr').find('th').text();
        $('#versionTitulo').text(version); // Actualizar el título del collapse

        var archivos = [
            { nombre: 'Archivo 1', contenido: 'Contenido del Archivo 1' },
            { nombre: 'Archivo 2', contenido: 'Contenido del Archivo 2' },
            { nombre: 'Archivo 3', contenido: 'Contenido del Archivo 3' }
        ];

        $('#listaArchivos').empty();

        archivos.forEach(function(archivo) {
            var accordionItem = $('<div class="accordion-item"></div>');
            var header = $('<h2 class="accordion-header"></h2>');
            var button = $('<button class="accordion-button" type="button"></button>').text(archivo.nombre);
            button.attr('data-bs-toggle', 'collapse');
            button.attr('data-bs-target', '#collapse-' + archivo.nombre.replace(/\s/g, ''));
            header.append(button);
            accordionItem.append(header);
            var collapse = $('<div class="accordion-collapse collapse"></div>').attr('id', 'collapse-' + archivo.nombre.replace(/\s/g, ''));
            var body = $('<div class="accordion-body"></div>').text(archivo.contenido);
            collapse.append(body);
            accordionItem.append(collapse);
            $('#listaArchivos').append(accordionItem);
        });
    });

    $('.ver-detalles').click(function() {
        // Obtener el valor de la versión de la fila seleccionada
        var version = $(this).closest('tr').find('th').text();
        $('#versionTituloDetalle').text(version); // Actualizar el título del collapse

        var detalles = [
            { nombre: 'Fix', contenido: 'Fix de la funcionalidad de pagos de salarios' },
            { nombre: 'Mejora', contenido: 'Se agregan mas pantallas el flujo de autorizacion' },
            { nombre: 'Mejora', contenido: 'Mejoras varias' }
        ];
        
        $('#listaDetalles').empty();

        detalles.forEach(function(detalle) {
            var accordionItem = $('<div class="accordion-item"></div>');
            var header = $('<h2 class="accordion-header"></h2>');
            var button = $('<button class="accordion-button" type="button"></button>').text(detalle.nombre);
            button.attr('data-bs-toggle', 'collapse');
            button.attr('data-bs-target', '#collapse-' + detalle.nombre.replace(/\s/g, ''));
            header.append(button);
            accordionItem.append(header);
            var collapse = $('<div class="accordion-collapse collapse"></div>').attr('id', 'collapse-' + detalle.nombre.replace(/\s/g, ''));
            var body = $('<div class="accordion-body"></div>').text(detalle.contenido);
            collapse.append(body);
            accordionItem.append(collapse);
            $('#listaDetalles').append(accordionItem);
        });
    });


    $('.ver-configuraciones').click(function() {
        // Obtener el valor de la versión de la fila seleccionada
        var version = $(this).closest('tr').find('th').text();
        $('#versionTituloConf').text(version); // Actualizar el título del collapse

        // var configuraciones = [
        //     { nombre: 'Configuración 1', contenido: 'Configuración 1' },
        //     { nombre: 'Configuración 2', contenido: 'Configuración 2' },
        //     { nombre: 'Configuración 3', contenido: 'Configuración 3' }
        // ];
        
        var configuraciones = [
            { nombre: 'styles.css', contenido: ' .resumen{ text-align: left}' },
            { nombre: 'versiones.js', contenido: "$('#listaArchivos').empty();" },
            { nombre: 'admin.env', contenido: '#SOURCE DB postgres host: 192.122.2.2' }
        ];
        
        $('#listaConf').empty();
        configuraciones.forEach(function(configuracion, index) {
            var id = 'collapse-' + index; // Usamos un índice para generar un id único
            var accordionItem = $('<div class="accordion-item"></div>');
            var header = $('<h2 class="accordion-header"></h2>');
            var button = $('<button class="accordion-button" type="button"></button>').text(configuracion.nombre);
            button.attr('data-bs-toggle', 'collapse');
            button.attr('data-bs-target', '#' + id);
            header.append(button);
            accordionItem.append(header);
            var collapse = $('<div class="accordion-collapse collapse"></div>').attr('id', id);
            collapse.attr('aria-labelledby', header.attr('id'));
            var body = $('<div class="accordion-body"></div>').html(configuracion.contenido);
            collapse.append(body);
            accordionItem.append(collapse);
            $('#listaConf').append(accordionItem);
        });
    });
});