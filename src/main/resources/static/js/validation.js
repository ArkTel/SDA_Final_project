const validationArrivaDate = () =>{
    const currentDate = new Date().getDate();
    if(arrivalDate < currentDate){
        return 'Wrong date!'
    }
}
const saveTourBtnElement = document.getElementById('saveTour');
saveTourBtnElement.addEventListener('click', () => {
    const tourInputElement = document.getElementById('arrivalDate');

    if (validationArrivaDate(tourInputElement.value)) {
        alert(validationArrivaDate(tourInputElement.value))
        return;
    }

})