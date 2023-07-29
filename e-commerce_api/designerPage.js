const userProfileContainer = document.getElementById('userProfileContainer');

// Make API call to signup endpoint and handle the response
fetch('https://localhost:8080/signup', {
  method: 'POST',
  body: JSON.stringify(userData),
  headers: {
    'Content-Type': 'application/json'
  }
})
  .then(response => response.json())
  .then(user => {
    // Process the retrieved user data

    // Create HTML markup for user profile
    const userProfileHTML = `
      <h2>User Profile</h2>
      <p>Name: ${user.name}</p>
      <p>Email: ${user.email}</p>
      <!-- Add more user data properties as needed -->
    `;

    // Insert the user profile HTML into the userProfileContainer element
    userProfileContainer.innerHTML = userProfileHTML;
  })
  .catch(error => {
    console.error('Error signing up:', error);
    // Handle the error, e.g., display an error message
    userProfileContainer.textContent = 'Error signing up. Please try again.';
  });




// document.getElementById("getUserForm").addEventListener("submit", function (event) {
//     event.preventDefault();

//     return fetch(`http://localhost:8080/designer/{id}`, {
//       method: 'GET',
//       headers: {
//         'Content-Type': 'application/json',
//       },
//     })
//       .then(response => {
//         if (response.ok) {
//           return response.json(data);
//         } else {
//           throw new Error('Failed to fetch user details');
//         }
//       })
//       .then(data => {
//         return data; // Return the user details response data
//       })
//       .catch(error => {
//         throw new Error(`Failed to fetch user details: ${error.message}`);
//       });
//     });
//   document.getElementById("signupForm").addEventListener("submit", function (event) {
//     event.preventDefault();

//     // Get signup form values
//     const name = document.getElementById('name').value;
//     const email = document.getElementById('email').value;
//     const password = document.getElementById('password').value;
//     const mobile = document.getElementById('mobile').value;
//     const addressline1 = document.getElementById('addressline1').value;
//     const addressline2 = document.getElementById('addressline2').value;
//     const landmark = document.getElementById('landmark').value;
//     const city = document.getElementById('city').value;
//     const state = document.getElementById('state').value;
//     const country = document.getElementById('country').value;
//     const pincode = document.getElementById('pincode').value;

//     const data = {
//         name: name,
//         email: email,
//         password: password,
//         mobile: mobile,
//         addressline1: addressline1,
//         addressline2: addressline2,
//         landmark: landmark,
//         city: city,
//         state: state,
//         country: country,
//         pincode: pincode
//     };

//     // Make API call to signup endpoint
//     // Replace API_ENDPOINT with your actual API endpoint
//     fetch("http://localhost:8080/register", {
//         // mode: "no-cors",
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//             // 'Accept': 'application/json',
//             // "Authorization": "API_KEY"
//         },
//         body: JSON.stringify(data)
//     })
//         .then(function (response) {
//             if (response.status == 200) {
//                 document.getElementById("message").textContent = "Signup Successful";
//             } else {
//                 document.getElementById("message").textContent = "Signup failed";
//             }
//         })
//         .catch(function (error) {
//             document.getElementById("message").textContent = "Signup failed. Please try again";
//         });
// });

// const userDataContainer = document.getElementById('userDataContainer');

// Fetch user data from the API endpoint
// fetch('https://api.example.com/users')
//   .then(response => response.json())
//   .then(userData => {
//     // Process the retrieved user data
//     // Here, we assume the userData is an array of user objects with properties like 'name', 'email', etc.

//     // Create an HTML template to display the user data
//     const htmlTemplate = `
//       <h2>User Data</h2>
//       <table>
//         <thead>
//           <tr>
//             <th>Name</th>
//             <th>Email</th>
//             <!-- Add more table headers as needed -->
//           </tr>
//         </thead>
//         <tbody>
//           ${userData.map(user => `
//             <tr>
//               <td>${user.name}</td>
//               <td>${user.email}</td>
//               <!-- Add more table cells for additional user data -->
//             </tr>
//           `).join('')}
//         </tbody>
//       </table>
//     `;

//     // Insert the HTML template into the userDataContainer element
//     userDataContainer.innerHTML = htmlTemplate;
//   })
//   .catch(error => {
//     console.error('Error fetching user data:', error);
//     // Handle the error, e.g., display an error message
//     userDataContainer.textContent = 'Error fetching user data. Please try again.';
//   });
