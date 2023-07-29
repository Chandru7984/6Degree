document.getElementById("signupForm").addEventListener("submit", function (event) {
    event.preventDefault();

    // Get signup form values
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const mobile = document.getElementById('mobile').value;
    const addressline1 = document.getElementById('addressline1').value;
    const addressline2 = document.getElementById('addressline2').value;
    const landmark = document.getElementById('landmark').value;
    const city = document.getElementById('city').value;
    const state = document.getElementById('state').value;
    const country = document.getElementById('country').value;
    const pincode = document.getElementById('pincode').value;

    const data = {
        name: name,
        email: email,
        password: password,
        mobile: mobile,
        addressline1: addressline1,
        addressline2: addressline2,
        landmark: landmark,
        city: city,
        state: state,
        country: country,
        pincode: pincode
    };

    // Make API call to signup endpoint
    // Replace API_ENDPOINT with your actual API endpoint
    fetch("http://localhost:8080/register", {
        // mode: "no-cors",
        method: "POST",
        headers: {
            "Content-Type": "application/json"
            // 'Accept': 'application/json',
            // "Authorization": "API_KEY"
        },
        body: JSON.stringify(data)
    })
        .then(function (response) {

            if (response.status == 200) {
                // document.getElementById("message1").textContent = "Signup Successful";
                window.location.href = "http://127.0.0.1:5500/getUser.html";
                // ?name=" + encodeURIComponent(data.name)+"&email="+encodeURIComponent(data.email)
                // +"&mobile="+encodeURIComponent(data.mobile)
                // +"&addressline1="+encodeURIComponent(data.addressline1)
                // +"&addressline2="+encodeURIComponent(data.addressline2)
                // +"&landmark="+encodeURIComponent(data.landmark)
                // +"&city="+encodeURIComponent(data.city)
                // +"&state="+encodeURIComponent(data.state)
                // +"&country="+encodeURIComponent(data.country)
                // +"&pincode="+encodeURIComponent(data.pincode);
            
            } else {
                document.getElementById("message2").textContent = "Email or Mobile number is already Exist";
            }
        })
        .catch(function (error) {
            document.getElementById("message3").textContent = "Signup failed. Please try again";
        });
});


//

// document.getElementById("signupForm").addEventListener("submit", function(event) {
//     event.preventDefault(); // Prevent form submission
  
//     // Fetch form data
//     var formData = new FormData(this);
    
//     // Make an AJAX request to the signup API endpoint
//     fetch("your-signup-api-endpoint", {
//       method: "POST",
//       body: formData
//     })
//     .then(response => response.json())
//     .then(data => {
//       // Redirect to another page with query parameters
//       window.location.href = "another-page.html?name=" + encodeURIComponent(data.name) + "&email=" + encodeURIComponent(data.email);
//     })
//     .catch(error => {
//       console.error("Signup failed:", error);
//     });
//   });
  