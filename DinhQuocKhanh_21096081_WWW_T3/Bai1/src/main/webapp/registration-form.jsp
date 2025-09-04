<%--
  Created by IntelliJ IDEA.
  User: kioma
  Date: 9/4/2025
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #a8e6cf, #7fcdcd);
            margin: 0;
            padding: 20px;
            min-height: 100vh;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background: rgba(135, 206, 235, 0.9);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }

        .form-row {
            display: flex;
            gap: 20px;
            margin-bottom: 15px;
            align-items: center;
        }

        .form-group {
            flex: 1;
            display: flex;
            align-items: center;
        }

        label {
            min-width: 120px;
            font-weight: bold;
            color: #333;
            margin-right: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        select,
        textarea {
            padding: 8px 12px;
            border: 2px solid #fff;
            border-radius: 5px;
            font-size: 14px;
            flex: 1;
            min-width: 150px;
        }

        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="tel"]:focus,
        select:focus,
        textarea:focus {
            outline: none;
            border-color: #4a90e2;
            box-shadow: 0 0 5px rgba(74, 144, 226, 0.5);
        }

        .date-group {
            display: flex;
            gap: 10px;
        }

        .date-group select {
            min-width: 80px;
        }

        .gender-group {
            display: flex;
            gap: 15px;
            align-items: center;
        }

        .gender-group label {
            min-width: auto;
            margin-right: 5px;
        }

        .hobbies-group {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
        }

        .hobbies-group label {
            min-width: auto;
            display: flex;
            align-items: center;
            gap: 5px;
        }

        textarea {
            resize: vertical;
            min-height: 80px;
            font-family: inherit;
        }

        .qualification-table {
            width: 100%;
            border-collapse: collapse;
            margin: 15px 0;
            background: rgba(255, 255, 255, 0.7);
            border-radius: 8px;
            overflow: hidden;
        }

        .qualification-table th,
        .qualification-table td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        .qualification-table th {
            background: rgba(74, 144, 226, 0.8);
            color: white;
            font-weight: bold;
        }

        .qualification-table input {
            width: 90%;
            min-width: 80px;
        }

        .course-group {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            margin-top: 10px;
        }

        .course-group label {
            min-width: auto;
            display: flex;
            align-items: center;
            gap: 5px;
        }

        .submit-group {
            text-align: center;
            margin-top: 30px;
            gap: 20px;
            display: flex;
            justify-content: center;
        }

        .submit-btn,
        .reset-btn {
            padding: 12px 30px;
            font-size: 16px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-weight: bold;
            transition: all 0.3s ease;
        }

        .submit-btn {
            background: linear-gradient(45deg, #4a90e2, #357abd);
            color: white;
        }

        .submit-btn:hover {
            background: linear-gradient(45deg, #357abd, #2a5d8f);
            transform: translateY(-2px);
        }

        .reset-btn {
            background: linear-gradient(45deg, #ff6b6b, #e55353);
            color: white;
        }

        .reset-btn:hover {
            background: linear-gradient(45deg, #e55353, #cc4444);
            transform: translateY(-2px);
        }

        .section-title {
            background: rgba(74, 144, 226, 0.8);
            color: white;
            padding: 10px 15px;
            margin: 20px -10px 15px -10px;
            border-radius: 8px;
            font-weight: bold;
            font-size: 16px;
        }

        .char-limit {
            font-size: 12px;
            color: #666;
            margin-left: 10px;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .form-row {
                flex-direction: column;
                gap: 10px;
            }

            .form-group {
                width: 100%;
            }

            label {
                min-width: auto;
                margin-bottom: 5px;
            }

            .qualification-table {
                font-size: 12px;
            }

            .qualification-table th,
            .qualification-table td {
                padding: 8px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1 style="text-align: center; color: #2c5aa0; margin-bottom: 30px; font-size: 28px;">
        Student Registration Form
    </h1>


    <form action="registration-form.jsp" name="formDangKy" method="GET">
        <!-- Personal Information -->
        <div class="form-row">
            <div class="form-group">
                <label for="firstName">First name:</label>
                <input type="text" id="firstName" name="firstName" maxlength="30" required>
                <span class="char-limit">(max 30 characters A-z and A-Z)</span>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="lastName">Last name:</label>
                <input type="text" id="lastName" name="lastName" maxlength="30" required>
                <span class="char-limit">(max 30 characters A-z and A-Z)</span>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="dateOfBirth">Date of birth:</label>
                <div class="date-group">
                    <select id="day" name="day" required>
                        <option value="">Day</option>
                        <script>
                            for(let i = 1; i <= 31; i++) {
                                document.write(`<option value="${i}">${i}</option>`);
                            }
                        </script>
                    </select>
                    <select id="month" name="month" required>
                        <option value="">Month</option>
                        <option value="1">January</option>
                        <option value="2">February</option>
                        <option value="3">March</option>
                        <option value="4">April</option>
                        <option value="5">May</option>
                        <option value="6">June</option>
                        <option value="7">July</option>
                        <option value="8">August</option>
                        <option value="9">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option>
                        <option value="12">December</option>
                    </select>
                    <select id="year" name="year" required>
                        <option value="">Year</option>
                        <script>
                            const currentYear = new Date().getFullYear();
                            for(let i = currentYear - 50; i <= currentYear; i++) {
                                document.write(`<option value="${i}">${i}</option>`);
                            }
                        </script>
                    </select>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="phoneNumber">Mobile number:</label>
                <input type="tel" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10,11}" required>
                <span class="char-limit">(10 digit number)</span>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Gender:</label>
                <div class="gender-group">
                    <label>
                        <input type="radio" name="gender" value="Male" required> Male
                    </label>
                    <label>
                        <input type="radio" name="gender" value="Female" required> Female
                    </label>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="address">Address:</label>
                <textarea id="address" name="address" placeholder="Enter your full address" required></textarea>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" id="city" name="city" maxlength="30" required>
                <span class="char-limit">(max 30 characters A-z and A-Z)</span>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="pinCode">Pin code:</label>
                <input type="text" id="pinCode" name="pinCode" pattern="[0-9]{5,6}" required>
                <span class="char-limit">(5-6 digit number)</span>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" id="state" name="state" maxlength="30" required>
                <span class="char-limit">(max 30 characters A-z and A-Z)</span>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="country">Country:</label>
                <input type="text" id="country" name="country" value="India" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Hobbies:</label>
                <div class="hobbies-group">
                    <label>
                        <input type="checkbox" name="hobbies" value="Drawing"> Drawing
                    </label>
                    <label>
                        <input type="checkbox" name="hobbies" value="Singing"> Singing
                    </label>
                    <label>
                        <input type="checkbox" name="hobbies" value="Dancing"> Dancing
                    </label>
                    <label>
                        <input type="checkbox" name="hobbies" value="Sketching"> Sketching
                    </label>
                    <label>
                        <input type="checkbox" name="hobbies" value="Other"> Other
                    </label>
                    <input type="text" name="otherHobby" placeholder="Specify other hobby" style="margin-left: 10px;">
                </div>
            </div>
        </div>

        <!-- Qualification Section -->
        <div class="section-title">Qualification</div>

        <table class="qualification-table">
            <thead>
            <tr>
                <th>Examination</th>
                <th>Board</th>
                <th>Percentage</th>
                <th>Year of Passing</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><strong>Class X</strong></td>
                <td><input type="text" name="classXBoard" placeholder="Board name"></td>
                <td><input type="number" name="classXPercentage" min="0" max="100" step="0.1" placeholder="0.0"></td>
                <td><input type="number" name="classXYearOfPassing" min="1980" max="2030" placeholder="YYYY"></td>
            </tr>
            <tr>
                <td><strong>Class XII</strong></td>
                <td><input type="text" name="classXIIBoard" placeholder="Board name"></td>
                <td><input type="number" name="classXIIPercentage" min="0" max="100" step="0.1" placeholder="0.0"></td>
                <td><input type="number" name="classXIIYearOfPassing" min="1980" max="2030" placeholder="YYYY"></td>
            </tr>
            <tr>
                <td><strong>Graduation</strong></td>
                <td><input type="text" name="graduationBoard" placeholder="University name"></td>
                <td><input type="number" name="graduationPercentage" min="0" max="100" step="0.1" placeholder="0.0"></td>
                <td><input type="number" name="graduationYearOfPassing" min="1980" max="2030" placeholder="YYYY"></td>
            </tr>
            <tr>
                <td><strong>Masters</strong></td>
                <td><input type="text" name="masterBoard" placeholder="University name"></td>
                <td><input type="number" name="masterPercentage" min="0" max="100" step="0.1" placeholder="0.0"></td>
                <td><input type="number" name="masterYearOfPassing" min="1980" max="2030" placeholder="YYYY"></td>
            </tr>
            </tbody>
        </table>

        <div class="form-row">
            <div class="form-group">
                <label>Course applied for:</label>
                <div class="course-group">
                    <label>
                        <input type="radio" name="courseAppliedFor" value="BCA" required> BCA
                    </label>
                    <label>
                        <input type="radio" name="courseAppliedFor" value="BBA" required> BBA
                    </label>
                    <label>
                        <input type="radio" name="courseAppliedFor" value="B.COM" required> B.COM
                    </label>
                    <label>
                        <input type="radio" name="courseAppliedFor" value="B.SC" required> B.SC
                    </label>
                    <label>
                        <input type="radio" name="courseAppliedFor" value="BA" required> BA
                    </label>
                    <label>
                        <input type="radio" name="courseAppliedFor" value="Other" required> Other
                    </label>
                </div>
            </div>
        </div>

        <div class="submit-group">
            <button type="submit" class="submit-btn">Submit</button>
            <button type="reset" class="reset-btn">Reset</button>
        </div>
    </form>
</div>

<script>
    // Validation and form enhancement
    document.addEventListener('DOMContentLoaded', function() {
        // Auto-populate year dropdown with realistic range
        const yearSelect = document.getElementById('year');
        const currentYear = new Date().getFullYear();

        // Add form validation
        const form = document.querySelector('form');
        form.addEventListener('submit', function(e) {
            e.preventDefault();

            // Basic validation
            const firstName = document.getElementById('firstName').value;
            const lastName = document.getElementById('lastName').value;
            const email = document.getElementById('email').value;

            if (!firstName.match(/^[A-Za-z\s]+$/)) {
                alert('First name should contain only letters');
                return;
            }

            if (!lastName.match(/^[A-Za-z\s]+$/)) {
                alert('Last name should contain only letters');
                return;
            }

            // If validation passes, you can submit the form
            alert('Form submitted successfully! (In real application, this would be processed by servlet)');
            // form.submit(); // Uncomment this line for actual submission
        });

        // Enable "Other" hobby text input only when "Other" is checked
        const otherHobbyCheckbox = document.querySelector('input[name="hobbies"][value="Other"]');
        const otherHobbyInput = document.querySelector('input[name="otherHobby"]');

        otherHobbyCheckbox.addEventListener('change', function() {
            otherHobbyInput.disabled = !this.checked;
            if (!this.checked) {
                otherHobbyInput.value = '';
            }
        });

        otherHobbyInput.disabled = true;
    });
</script>
</body>
</html>
