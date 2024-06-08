var canvasPrinter;
const getR = function (){
    return parseFloat(document.getElementById("form:R-value").value);
}

function checkboxListener(){
    let checkboxes = document.querySelectorAll(".checkbox");
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener("click", event => {
            if (!checkbox.checked) event.preventDefault();
            checkboxes.forEach(another => {
                if (another !== checkbox)
                    another.checked = false
            });
        })
    })
    checkboxes.forEach(checkbox => checkbox.checked = false);
    checkboxes[Math.round(canvasPrinter.lastClickedX) + 3].checked = true
}

window.onload = function () {
    canvasPrinter = new CanvasPrinter();
    canvasPrinter.drawStartImage()
    canvasPrinter.lastClickedR = getR();

    if(canvasPrinter.lastClickedR && canvasPrinter.lastClickedR <= 4 && canvasPrinter.lastClickedR >= 1){
        // I have no reason why canvasPrinter.redrawAll is undefined.....
        canvasPrinter.ctx.clearRect(0, 0, canvasPrinter.canvas.width, canvasPrinter.ctx.height);
        canvasPrinter.drawGraph(getR());
        canvasPrinter.drawAxes();
        canvasPrinter.setPointerAtDot(3);
        canvasPrinter.setPointerAtDot(1);
        canvasPrinter.drawPoints();
    }

    canvasPrinter.canvas.addEventListener('click', function (event) {
        canvasPrinter.parseClick(event)
    });
    checkboxListener();
    setInterval(checkUpdate, 12000);
};
