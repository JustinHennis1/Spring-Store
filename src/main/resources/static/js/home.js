document.addEventListener('DOMContentLoaded', function () {
  // Make sure Bootstrap is loaded before trying to use it
  if (typeof bootstrap === 'undefined') {
    console.error("Bootstrap is not loaded! Modal functionality won't work.");
    return;
  }

  // Log to verify the script is running
  //console.log("Home.js loaded and running");

  // Get all edit buttons
  const editButtons = document.querySelectorAll('.edit-product-btn');
  //console.log("Found edit buttons:", editButtons.length);

  // Try to initialize the modal
  let modal;
  try {
    const modalElement = document.getElementById('editProductModal');
    if (!modalElement) {
      console.error("Modal element not found!");
      return;
    }
    modal = new bootstrap.Modal(modalElement);
    //console.log("Modal initialized successfully");
  } catch (error) {
    console.error("Error initializing modal:", error);
    return;
  }

  // Add click event listeners to each edit button
  editButtons.forEach(button => {
    button.addEventListener('click', function(event) {
      console.log("Edit button clicked");

      // Log the button and its data attributes to debug
      console.log("Button:", this);
      console.log("Data attributes:",
        this.getAttribute('data-id'),
        this.getAttribute('data-title'),
        this.getAttribute('data-description'),
        this.getAttribute('data-price')
      );

      // Set form values using getAttribute instead of dataset
      document.getElementById('modalProductId').value = this.getAttribute('data-id');
      document.getElementById('modalTitle').value = this.getAttribute('data-title');
      document.getElementById('modalDescription').value = this.getAttribute('data-description');
      document.getElementById('modalPrice').value = this.getAttribute('data-price');

      // Show the modal
      modal.show();
    });
    //console.log("Added click listener to button:", button);
  });
});