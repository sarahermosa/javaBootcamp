const resourceUrl = 'https://rickandmortyapi.com/api/character/';

$.ajax({
    url: resourceUrl,
    method: 'GET',
    success: function(response) {
      const html = response.results.map(item =>
        `<li>
          <img src="${item.image}" alt="" />
          ${item.name}
        </li>`
      );
      
      $('.character-list').html(html.join(''));
    },
    error: function(err) {
      console.log(err);
    }
  });