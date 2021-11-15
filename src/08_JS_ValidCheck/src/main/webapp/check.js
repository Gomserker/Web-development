function call(){
    let i1Input = document.myForm.i1;
    let i2Input = document.myForm.i2;
    let i3Input = document.myForm.i3;
    let i4Input = document.myForm.i4;
    let i5Input = document.myForm.i5;

    if(isEmpty(i1Input) || lessThan(i1Input, 3) || conatinKR(i1Input)){
        alert('required error');

        i1Input.focus();
        i1Input.value = "";

        return false;
    }

    // if(lessThan(i1Input, 3)){
    //     alert('required error, input more than 3 characters');
    //     i1Input.value = "";
    //     i1Input.focus();

    //     return false;
    // }

    if(lessThan(i2Input, 3)){
        alert('too less input');

        i2Input.focus();
        i2Input.value = "";

        return false;
    }

    if(lessThan(i3Input, 5)){
        alert('invalid password');

        i3Input.value = "";
        i3Input.focus();
        return false;
    }

    if(notContains(i3Input, "1234567890") || notContains(i3Input, "QWERTYUIOPASDFGHJKLZXCVBNM")){
        alert('must contain uppercase and number');

        i3Input.value = "";
        i3Input.focus();
        return false;
    }

    if(notEquals(i3Input, i4Input)){
        alert('not same password');

        i4Input.value="";
        i4Input.focus();
        return false;
    }

    if(isNotNumber(i5Input) || isEmpty(i5Input)){
        alert('only numbers allowed');
        i5Input.value="";
        i5Input.focus();
        return false;
    }

    return true;
}

