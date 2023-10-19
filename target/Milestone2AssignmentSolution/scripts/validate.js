/**
 * Validating the forms
 */

function validate() {
	//alert('test')
	let name = frmBatch.name.value
	let startTime = frmBatch.startTime.value
	let endTime = frmBatch.endTime.value
	let shift = frmBatch.shift.value
	if (name === "") {
		alert('Please, give a name to your Batch')
		frmBatch.name.focus()
		return false
	} else if (startTime === "") {
		alert('Please, set a start and end time for your Batch')
		frmBatch.name.focus()
		return false
	} else if (endTime === "") {
		alert('Please, set a start and end time for your Batch')
		frmBatch.name.focus()
		return false
	} else if (shift === "") {
		alert('Please, define if is AM or PM')
		frmBatch.name.focus()
		return false
	} else {
		document.forms["frmBatch"].submit()
	}
}