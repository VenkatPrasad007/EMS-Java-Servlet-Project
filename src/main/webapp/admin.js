/**
 * 
 */



	let empser = document.getElementById('seremp');
	empser.addEventListener('click', (e) => {
	  e.preventDefault();
	  e.stopPropagation();

	  const userInput = document.querySelector('input[type="search"]').value;
	  console.log("User ID:", userInput);

	  const ur = 'http://localhost:8080/EMS/api/user?user=' + userInput;

	  fetch(ur, {
	    method: 'GET'
	  })
	    .then(res => res.text()) // because servlet returns HTML
	    .then(data => {
	      console.log(data);
	      // Display result in a div
	      document.body.insertAdjacentHTML('beforeend', `<div class="container mt-3">${data}</div>`);
	    })
	    .catch(err => console.error("Fetch error:", err));
	});