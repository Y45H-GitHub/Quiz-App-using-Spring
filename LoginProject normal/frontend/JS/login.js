async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    try {
      const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
      });
      if (response.ok) {
        alert("Login successful!");
        // Redirect or handle successful login
      } else {
        alert("Login failed. Check your credentials.");
      }
    } catch (error) {
      console.error('Error:', error);
      alert("An error occurred while logging in.");
    }
  }
  