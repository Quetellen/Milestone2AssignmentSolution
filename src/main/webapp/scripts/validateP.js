/**
 * Validating the forms
 */

function validatep() {
	let pname = frmParticipant.pname.value
	let phone = frmParticipant.phone.value
	let email = frmParticipant.email.value
	let b_id = frmParticipant.b_id.value

	if (pname === "") {
		alert('Please, provide your name')
		frmParticipant.name.focus()
		return false
	} else if (phone === "") {
		alert('Please, provide your phone number')
		frmParticipant.name.focus()
		return false
	} else if (email === "") {
		alert('Please, provide your email')
		frmParticipant.name.focus()
		return false
	} else if (b_id === "") {
		alert('Please, provide batch id')
		frmParticipant.name.focus()
		return false
	} else {
		document.forms["frmParticipant"].submit()
	}
}