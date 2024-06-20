document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const url = 'http://localhost:8080/api/login';
    const data = {
        email: email,
        password: password
    };

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error('Login failed');
        }

        const responseData = await response.json();
        console.log(responseData); // handle the response data as needed
        
        // Example: redirect to another page or display user info
        displayUserInfo(responseData);
        
    } catch (error) {
        console.error('Error:', error);
        displayErrorMessage('Invalid email or password.');
    }
});

function displayUserInfo(user) {
    const message = document.getElementById('message');
    message.textContent = `Welcome, ${user.username}!`;
    message.classList.remove('hidden');
}

function displayErrorMessage(message) {
    const errorMessage = document.getElementById('message');
    errorMessage.textContent = message;
    errorMessage.classList.remove('hidden');
}
