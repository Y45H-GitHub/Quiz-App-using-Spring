async function register() {
  const username = document.getElementById('username').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  try {
      const response = await fetch('http://localhost:8080/api/register', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({ username, email, password })
      });

      if (response.ok) {
          alert("Registration successful!");
          // Redirect to login page or handle successful registration
          window.location.href = "login.html";
      } else {
          // Get the error message from the response body
          const errorMessage = await response.text();

          if (response.status === 400) {
              alert(errorMessage); // Display the specific error message
          } else {
              alert("Registration failed. Please try again.");
          }
      }
  } catch (error) {
      console.error('Error:', error);
      alert("An error occurred during registration. Please check your connection and try again.");
  }
}
