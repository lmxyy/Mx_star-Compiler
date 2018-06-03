global main

extern malloc
section .text

___hex2int:
___hex2int..hex2int.entry:
	push rbp
	mov rbp,rsp
	sub rsp,336
	mov qword [rbp-48],rdi
	mov r8,0
	mov qword [rbp-120],r8
	mov r8,0
	mov qword [rbp-232],r8
	mov r8,0
	mov qword [rbp-120],r8
	jmp ___hex2int..for_cond
___hex2int..for_cond:
	mov r8,qword [rbp-48]
	mov r9,qword [r8]
	mov qword [rbp-224],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-224]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-208],r10
	mov r8,qword [rbp-208]
	cmp r8b,1
	jz ___hex2int..for_loop
	jnz ___hex2int..for_after
___hex2int..for_after:
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-72],r9
	jmp ___hex2int..hex2int.exit
___hex2int..for_loop:
	mov qword [rbp-264],r8
	mov qword [rbp-272],r10
	mov qword [rbp-280],r9
	mov rsi,qword [rbp-120]
	mov rdi,qword [rbp-48]
	call _Z9stringOrdPci
	mov r9,qword [rbp-280]
	mov r10,qword [rbp-272]
	mov r8,qword [rbp-264]
	mov r8,rax
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	cmp r8,48
	mov r9,0
	setge r9b
	mov qword [rbp-248],r9
	mov r8,qword [rbp-248]
	cmp r8b,1
	jz ___hex2int..lhs_true
	jnz ___hex2int..lhs_false
___hex2int..lhs_false:
	mov r8,0
	mov qword [rbp-104],r8
	jmp ___hex2int..lhs_merge
___hex2int..lhs_true:
	mov r8,qword [rbp-32]
	cmp r8,57
	mov r9,0
	setle r9b
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-104],r9
	jmp ___hex2int..lhs_merge
___hex2int..lhs_merge:
	mov r8,qword [rbp-104]
	cmp r8b,1
	jz ___hex2int..if_true
	jnz ___hex2int..if_false
___hex2int..if_true:
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-240],r9
	mov r8,qword [rbp-240]
	imul r8,16
	mov qword [rbp-240],r8
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-64]
	add r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	sub r8,48
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-232],r9
	jmp ___hex2int..if_after
___hex2int..if_false:
	mov r8,qword [rbp-32]
	cmp r8,65
	mov r9,0
	setge r9b
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	cmp r8b,1
	jz ___hex2int..lhs_true_2
	jnz ___hex2int..lhs_false_2
___hex2int..lhs_true_2:
	mov r8,qword [rbp-32]
	cmp r8,70
	mov r9,0
	setle r9b
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-112],r9
	jmp ___hex2int..lhs_merge_2
___hex2int..lhs_false_2:
	mov r8,0
	mov qword [rbp-112],r8
	jmp ___hex2int..lhs_merge_2
___hex2int..lhs_merge_2:
	mov r8,qword [rbp-112]
	cmp r8b,1
	jz ___hex2int..if_true_2
	jnz ___hex2int..if_false_2
___hex2int..if_true_2:
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	imul r8,16
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-128]
	add r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-176]
	sub r8,65
	mov qword [rbp-176],r8
	mov r8,qword [rbp-176]
	mov r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-192]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	add r8,10
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-232],r9
	jmp ___hex2int..if_after_2
___hex2int..if_false_2:
	mov r8,qword [rbp-32]
	cmp r8,97
	mov r9,0
	setge r9b
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	cmp r8b,1
	jz ___hex2int..lhs_true_3
	jnz ___hex2int..lhs_false_3
___hex2int..lhs_true_3:
	mov r8,qword [rbp-32]
	cmp r8,102
	mov r9,0
	setle r9b
	mov qword [rbp-160],r9
	mov r8,qword [rbp-160]
	mov r9,r8
	mov qword [rbp-200],r9
	jmp ___hex2int..lhs_merge_3
___hex2int..lhs_false_3:
	mov r8,0
	mov qword [rbp-200],r8
	jmp ___hex2int..lhs_merge_3
___hex2int..lhs_merge_3:
	mov r8,qword [rbp-200]
	cmp r8b,1
	jz ___hex2int..if_true_3
	jnz ___hex2int..if_false_3
___hex2int..if_false_3:
	mov r8,0
	mov qword [rbp-72],r8
	jmp ___hex2int..hex2int.exit
___hex2int..hex2int.exit:
	mov r8,qword [rbp-72]
	mov rax,r8
	leave
	ret
___hex2int..if_true_3:
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-88]
	imul r8,16
	mov qword [rbp-88],r8
	mov r8,qword [rbp-88]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-184]
	add r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-184]
	mov r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-216]
	sub r8,97
	mov qword [rbp-216],r8
	mov r8,qword [rbp-216]
	mov r9,r8
	mov qword [rbp-168],r9
	mov r8,qword [rbp-168]
	mov r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-256]
	add r8,10
	mov qword [rbp-256],r8
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-232],r9
	jmp ___hex2int..if_after_3
___hex2int..if_after_3:
	jmp ___hex2int..if_after_2
___hex2int..if_after_2:
	jmp ___hex2int..if_after
___hex2int..if_after:
	jmp ___hex2int..for_step
___hex2int..for_step:
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-120]
	add r8,1
	mov qword [rbp-120],r8
	jmp ___hex2int..for_cond

___int2chr:
___int2chr..int2chr.entry:
	push rbp
	mov rbp,rsp
	sub rsp,160
	mov qword [rbp-72],rdi
	mov r8,qword [___asciiTable]
	mov qword [rbp-64],r8
	mov r8,___string
	mov qword [rbp-48],r8
	mov r8,qword [rbp-72]
	cmp r8,32
	mov r9,0
	setge r9b
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	cmp r8b,1
	jz ___int2chr..lhs_true
	jnz ___int2chr..lhs_false
___int2chr..lhs_true:
	mov r8,qword [rbp-72]
	cmp r8,126
	mov r9,0
	setle r9b
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-88],r9
	jmp ___int2chr..lhs_merge
___int2chr..lhs_false:
	mov r8,0
	mov qword [rbp-88],r8
	jmp ___int2chr..lhs_merge
___int2chr..lhs_merge:
	mov r8,qword [rbp-88]
	cmp r8b,1
	jz ___int2chr..if_true
	jnz ___int2chr..if_after
___int2chr..if_after:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-56],r9
	jmp ___int2chr..int2chr.exit
___int2chr..if_true:
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	sub r8,32
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	sub r8,32
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-80],r9
	mov qword [rbp-104],r8
	mov qword [rbp-112],r9
	mov rdx,qword [rbp-80]
	mov rsi,qword [rbp-32]
	mov rdi,qword [rbp-64]
	call _Z15stringSubStringPcii
	mov r9,qword [rbp-112]
	mov r8,qword [rbp-104]
	mov r8,rax
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-56],r9
	jmp ___int2chr..int2chr.exit
___int2chr..int2chr.exit:
	mov r8,qword [rbp-56]
	mov rax,r8
	leave
	ret

___toStringHex:
___toStringHex..toStringHex.entry:
	push rbp
	mov rbp,rsp
	sub rsp,224
	mov qword [rbp-16],rdi
	mov r8,___string
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,0
	mov qword [rbp-40],r8
	mov r8,28
	mov qword [rbp-40],r8
	jmp ___toStringHex..for_cond
___toStringHex..for_cond:
	mov r8,qword [rbp-40]
	cmp r8,0
	mov r9,0
	setge r9b
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	cmp r8b,1
	jz ___toStringHex..for_loop
	jnz ___toStringHex..for_after
___toStringHex..for_loop:
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-40]
	mov rcx,r8
	mov r8,qword [rbp-128]
	sar r8,cl
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	and r8,15
	mov qword [rbp-80],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	cmp r8,10
	mov r9,0
	setl r9b
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	cmp r8b,1
	jz ___toStringHex..if_true
	jnz ___toStringHex..if_false
___toStringHex..if_true:
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	add r8,48
	mov qword [rbp-72],r8
	mov qword [rbp-160],r8
	mov qword [rbp-168],r9
	mov qword [rbp-176],rdi
	mov rdi,qword [rbp-72]
	call ___int2chr
	mov rdi,qword [rbp-176]
	mov r9,qword [rbp-168]
	mov r8,qword [rbp-160]
	mov r8,rax
	mov qword [rbp-104],r8
	mov r8,___string
	mov qword [rbp-32],r8
	mov qword [rbp-160],r8
	mov qword [rbp-168],r9
	mov rsi,qword [rbp-104]
	mov rdi,qword [rbp-64]
	call _Z12stringConcatPcS_
	mov r9,qword [rbp-168]
	mov r8,qword [rbp-160]
	mov r8,rax
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-64],r9
	jmp ___toStringHex..if_after
___toStringHex..if_false:
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-112]
	add r8,65
	mov qword [rbp-112],r8
	mov r8,qword [rbp-112]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	sub r8,10
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-8],r9
	mov qword [rbp-160],r8
	mov qword [rbp-168],r9
	mov qword [rbp-176],rdi
	mov rdi,qword [rbp-8]
	call ___int2chr
	mov rdi,qword [rbp-176]
	mov r9,qword [rbp-168]
	mov r8,qword [rbp-160]
	mov r8,rax
	mov qword [rbp-88],r8
	mov r8,___string
	mov qword [rbp-32],r8
	mov qword [rbp-160],r8
	mov qword [rbp-168],r9
	mov rsi,qword [rbp-88]
	mov rdi,qword [rbp-64]
	call _Z12stringConcatPcS_
	mov r9,qword [rbp-168]
	mov r8,qword [rbp-160]
	mov r8,rax
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-64],r9
	jmp ___toStringHex..if_after
___toStringHex..if_after:
	jmp ___toStringHex..for_step
___toStringHex..for_step:
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-152]
	sub r8,4
	mov qword [rbp-152],r8
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-40],r9
	jmp ___toStringHex..for_cond
___toStringHex..for_after:
	mov r8,qword [rbp-64]
	mov rax,r8
	leave
	ret

___rotate_left:
___rotate_left..rotate_left.entry:
	push rbp
	mov rbp,rsp
	sub rsp,304
	mov qword [rbp-240],rdi
	mov qword [rbp-48],rsi
	mov r8,qword [rbp-48]
	cmp r8,1
	mov r9,0
	sete r9b
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	cmp r8b,1
	jz ___rotate_left..if_true
	jnz ___rotate_left..if_after
___rotate_left..if_after:
	mov r8,qword [rbp-48]
	cmp r8,31
	mov r9,0
	sete r9b
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	cmp r8b,1
	jz ___rotate_left..if_true_2
	jnz ___rotate_left..if_after_2
___rotate_left..if_true_2:
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-192]
	and r8,1
	mov qword [rbp-192],r8
	mov r8,qword [rbp-192]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,qword [rbp-208]
	sal r8,31
	mov qword [rbp-208],r8
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-232]
	sar r8,1
	mov qword [rbp-232],r8
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	and r8,2147483647
	mov qword [rbp-72],r8
	mov r8,qword [rbp-208]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-72]
	mov r9,qword [rbp-120]
	or r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-216],r9
	jmp ___rotate_left..rotate_left.exit
___rotate_left..if_after_2:
	mov r8,32
	mov qword [rbp-64],r8
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-64]
	sub r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,1
	mov qword [rbp-104],r8
	mov r8,qword [rbp-112]
	mov rcx,r8
	mov r8,qword [rbp-104]
	sal r8,cl
	mov qword [rbp-104],r8
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	sub r8,1
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-8]
	mov r9,qword [rbp-24]
	and r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-48]
	mov rcx,r8
	mov r8,qword [rbp-128]
	sal r8,cl
	mov qword [rbp-128],r8
	mov r8,32
	mov qword [rbp-56],r8
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-56]
	sub r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-200]
	mov rcx,r8
	mov r8,qword [rbp-152]
	sar r8,cl
	mov qword [rbp-152],r8
	mov r8,1
	mov qword [rbp-136],r8
	mov r8,qword [rbp-48]
	mov rcx,r8
	mov r8,qword [rbp-136]
	sal r8,cl
	mov qword [rbp-136],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	sub r8,1
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-168],r9
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-168]
	mov r9,qword [rbp-176]
	and r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-176]
	mov r9,qword [rbp-224]
	or r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-224]
	mov r9,r8
	mov qword [rbp-216],r9
	jmp ___rotate_left..rotate_left.exit
___rotate_left..if_true:
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-88]
	and r8,2147483647
	mov qword [rbp-88],r8
	mov r8,qword [rbp-88]
	mov r9,r8
	mov qword [rbp-160],r9
	mov r8,qword [rbp-160]
	sal r8,1
	mov qword [rbp-160],r8
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	sar r8,31
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	and r8,1
	mov qword [rbp-80],r8
	mov r8,qword [rbp-160]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-80]
	mov r9,qword [rbp-184]
	or r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-184]
	mov r9,r8
	mov qword [rbp-216],r9
	jmp ___rotate_left..rotate_left.exit
___rotate_left..rotate_left.exit:
	mov r8,qword [rbp-216]
	mov rax,r8
	leave
	ret

___add:
___add..add.entry:
	push rbp
	mov rbp,rsp
	sub rsp,208
	mov qword [rbp-48],rdi
	mov qword [rbp-32],rsi
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	and r8,65535
	mov qword [rbp-8],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	and r8,65535
	mov qword [rbp-128],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-128]
	mov r9,qword [rbp-104]
	add r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-88]
	sar r8,16
	mov qword [rbp-88],r8
	mov r8,qword [rbp-88]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	and r8,65535
	mov qword [rbp-24],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	sar r8,16
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	and r8,65535
	mov qword [rbp-72],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-72]
	mov r9,qword [rbp-136]
	add r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	sar r8,16
	mov qword [rbp-120],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-64]
	add r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	and r8,65535
	mov qword [rbp-80],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-112]
	sal r8,16
	mov qword [rbp-112],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	and r8,65535
	mov qword [rbp-16],r8
	mov r8,qword [rbp-112]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-56]
	or r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	mov rax,r8
	leave
	ret

___lohi:
___lohi..lohi.entry:
	push rbp
	mov rbp,rsp
	sub rsp,96
	mov qword [rbp-32],rdi
	mov qword [rbp-16],rsi
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	sal r8,16
	mov qword [rbp-24],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-24]
	mov r9,qword [rbp-8]
	or r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	mov rax,r8
	leave
	ret

___sha1:
___sha1..sha1.entry:
	push rbp
	mov rbp,rsp
	sub rsp,1392
	mov qword [rbp-808],rdi
	mov qword [rbp-456],rsi
	mov r8,qword [___chunks]
	mov qword [rbp-728],r8
	mov r8,qword [___MAXCHUNK]
	mov qword [rbp-856],r8
	mov r8,___string_2
	mov qword [rbp-616],r8
	mov r8,qword [___outputBuffer]
	mov qword [rbp-1160],r8
	mov r8,qword [rbp-456]
	mov r9,r8
	mov qword [rbp-608],r9
	mov r8,qword [rbp-608]
	add r8,64
	mov qword [rbp-608],r8
	mov r8,qword [rbp-608]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	sub r8,56
	mov qword [rbp-24],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-768],r9
	mov r8,qword [rbp-768]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-640],r8
	mov r8,qword [rbp-640]
	idiv r8
	mov r8,rax
	mov qword [rbp-1216],r8
	mov r8,qword [rbp-1216]
	mov r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-176]
	add r8,1
	mov qword [rbp-176],r8
	mov r8,qword [rbp-176]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	mov r9,qword [rbp-856]
	cmp r8,r9
	mov r10,0
	setg r10b
	mov qword [rbp-1024],r10
	mov r8,qword [rbp-1024]
	cmp r8b,1
	jz ___sha1..if_true
	jnz ___sha1..if_after
___sha1..if_true:
	mov qword [rbp-1320],r8
	mov qword [rbp-1328],r10
	mov qword [rbp-1336],r9
	mov rdi,qword [rbp-616]
	call _Z7printlnPc
	mov r9,qword [rbp-1336]
	mov r10,qword [rbp-1328]
	mov r8,qword [rbp-1320]
	mov r8,0
	mov qword [rbp-1136],r8
	jmp ___sha1..sha1.exit
___sha1..if_after:
	mov r8,0
	mov qword [rbp-288],r8
	mov r8,0
	mov qword [rbp-944],r8
	mov r8,0
	mov qword [rbp-288],r8
	jmp ___sha1..for_cond
___sha1..for_cond:
	mov r8,qword [rbp-288]
	mov r9,qword [rbp-80]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-1080],r10
	mov r8,qword [rbp-1080]
	cmp r8b,1
	jz ___sha1..for_loop
	jnz ___sha1..for_after
___sha1..for_loop:
	mov r8,0
	mov qword [rbp-944],r8
	jmp ___sha1..for_cond_2
___sha1..for_cond_2:
	mov r8,qword [rbp-944]
	cmp r8,80
	mov r9,0
	setl r9b
	mov qword [rbp-784],r9
	mov r8,qword [rbp-784]
	cmp r8b,1
	jz ___sha1..for_loop_2
	jnz ___sha1..for_after_2
___sha1..for_after_2:
	jmp ___sha1..for_step
___sha1..for_step:
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-648],r9
	mov r8,qword [rbp-288]
	add r8,1
	mov qword [rbp-288],r8
	jmp ___sha1..for_cond
___sha1..for_loop_2:
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-448],r9
	mov r8,qword [rbp-448]
	imul r8,8
	mov qword [rbp-448],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-448]
	add r9,r8
	mov qword [rbp-448],r9
	mov r8,qword [rbp-448]
	mov r8,qword [r8+8]
	mov qword [rbp-448],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-1208],r9
	mov r8,qword [rbp-1208]
	imul r8,8
	mov qword [rbp-1208],r8
	mov r8,qword [rbp-448]
	mov r9,qword [rbp-1208]
	add r9,r8
	mov qword [rbp-1208],r9
	mov r8,qword [rbp-1208]
	mov qword [r8+8],0
	jmp ___sha1..for_step_2
___sha1..for_step_2:
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-1128],r9
	mov r8,qword [rbp-944]
	add r8,1
	mov qword [rbp-944],r8
	jmp ___sha1..for_cond_2
___sha1..for_after:
	mov r8,0
	mov qword [rbp-288],r8
	jmp ___sha1..for_cond_3
___sha1..for_cond_3:
	mov r8,qword [rbp-288]
	mov r9,qword [rbp-456]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-696],r10
	mov r8,qword [rbp-696]
	cmp r8b,1
	jz ___sha1..for_loop_3
	jnz ___sha1..for_after_3
___sha1..for_loop_3:
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-488],r8
	mov r8,qword [rbp-488]
	idiv r8
	mov r8,rax
	mov qword [rbp-704],r8
	mov r8,qword [rbp-704]
	mov r9,r8
	mov qword [rbp-744],r9
	mov r8,qword [rbp-744]
	imul r8,8
	mov qword [rbp-744],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-744]
	add r9,r8
	mov qword [rbp-744],r9
	mov r8,qword [rbp-744]
	mov r8,qword [r8+8]
	mov qword [rbp-744],r8
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-1256],r8
	mov r8,qword [rbp-1256]
	idiv r8
	mov r8,rdx
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-1032],r8
	mov r8,qword [rbp-1032]
	idiv r8
	mov r8,rax
	mov qword [rbp-352],r8
	mov r8,qword [rbp-352]
	mov r9,r8
	mov qword [rbp-296],r9
	mov r8,qword [rbp-296]
	imul r8,8
	mov qword [rbp-296],r8
	mov r8,qword [rbp-744]
	mov r9,qword [rbp-296]
	add r9,r8
	mov qword [rbp-296],r9
	mov r8,qword [rbp-296]
	mov r8,qword [r8+8]
	mov qword [rbp-296],r8
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-680],r9
	mov r8,qword [rbp-680]
	imul r8,8
	mov qword [rbp-680],r8
	mov r8,qword [rbp-808]
	mov r9,qword [rbp-680]
	add r9,r8
	mov qword [rbp-680],r9
	mov r8,qword [rbp-680]
	mov r8,qword [r8+8]
	mov qword [rbp-680],r8
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-1048],r8
	mov r8,qword [rbp-1048]
	idiv r8
	mov r8,rdx
	mov qword [rbp-1312],r8
	mov r8,3
	mov qword [rbp-360],r8
	mov r8,qword [rbp-1312]
	mov r9,qword [rbp-360]
	sub r9,r8
	mov qword [rbp-360],r9
	mov r8,qword [rbp-360]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-1016],r9
	mov r8,qword [rbp-1016]
	imul r8,8
	mov qword [rbp-1016],r8
	mov r8,qword [rbp-680]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-1016]
	mov rcx,r8
	mov r8,qword [rbp-32]
	sal r8,cl
	mov qword [rbp-32],r8
	mov r8,qword [rbp-296]
	mov r9,r8
	mov qword [rbp-1248],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-1248]
	or r9,r8
	mov qword [rbp-1248],r9
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-720],r8
	mov r8,qword [rbp-720]
	idiv r8
	mov r8,rax
	mov qword [rbp-424],r8
	mov r8,qword [rbp-424]
	mov r9,r8
	mov qword [rbp-1120],r9
	mov r8,qword [rbp-1120]
	imul r8,8
	mov qword [rbp-1120],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-1120]
	add r9,r8
	mov qword [rbp-1120],r9
	mov r8,qword [rbp-1120]
	mov r8,qword [r8+8]
	mov qword [rbp-1120],r8
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-904],r8
	mov r8,qword [rbp-904]
	idiv r8
	mov r8,rdx
	mov qword [rbp-328],r8
	mov r8,qword [rbp-328]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-592],r8
	mov r8,qword [rbp-592]
	idiv r8
	mov r8,rax
	mov qword [rbp-472],r8
	mov r8,qword [rbp-472]
	mov r9,r8
	mov qword [rbp-272],r9
	mov r8,qword [rbp-272]
	imul r8,8
	mov qword [rbp-272],r8
	mov r8,qword [rbp-1120]
	mov r9,qword [rbp-272]
	add r9,r8
	mov qword [rbp-272],r9
	mov r8,qword [rbp-272]
	mov r9,qword [rbp-1248]
	mov qword [r8+8],r9
	jmp ___sha1..for_step_3
___sha1..for_step_3:
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-928],r9
	mov r8,qword [rbp-288]
	add r8,1
	mov qword [rbp-288],r8
	jmp ___sha1..for_cond_3
___sha1..for_after_3:
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-832],r8
	mov r8,qword [rbp-832]
	idiv r8
	mov r8,rax
	mov qword [rbp-72],r8
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-736],r9
	mov r8,qword [rbp-736]
	imul r8,8
	mov qword [rbp-736],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-736]
	add r9,r8
	mov qword [rbp-736],r9
	mov r8,qword [rbp-736]
	mov r8,qword [r8+8]
	mov qword [rbp-736],r8
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-872],r8
	mov r8,qword [rbp-872]
	idiv r8
	mov r8,rdx
	mov qword [rbp-248],r8
	mov r8,qword [rbp-248]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-224],r8
	mov r8,qword [rbp-224]
	idiv r8
	mov r8,rax
	mov qword [rbp-64],r8
	mov r8,qword [rbp-64]
	mov r9,r8
	mov qword [rbp-1072],r9
	mov r8,qword [rbp-1072]
	imul r8,8
	mov qword [rbp-1072],r8
	mov r8,qword [rbp-736]
	mov r9,qword [rbp-1072]
	add r9,r8
	mov qword [rbp-1072],r9
	mov r8,qword [rbp-1072]
	mov r8,qword [r8+8]
	mov qword [rbp-1072],r8
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-1240],r8
	mov r8,qword [rbp-1240]
	idiv r8
	mov r8,rdx
	mov qword [rbp-800],r8
	mov r8,3
	mov qword [rbp-392],r8
	mov r8,qword [rbp-800]
	mov r9,qword [rbp-392]
	sub r9,r8
	mov qword [rbp-392],r9
	mov r8,qword [rbp-392]
	mov r9,r8
	mov qword [rbp-656],r9
	mov r8,qword [rbp-656]
	mov r9,r8
	mov qword [rbp-752],r9
	mov r8,qword [rbp-752]
	imul r8,8
	mov qword [rbp-752],r8
	mov r8,128
	mov qword [rbp-760],r8
	mov r8,qword [rbp-752]
	mov rcx,r8
	mov r8,qword [rbp-760]
	sal r8,cl
	mov qword [rbp-760],r8
	mov r8,qword [rbp-1072]
	mov r9,r8
	mov qword [rbp-840],r9
	mov r8,qword [rbp-760]
	mov r9,qword [rbp-840]
	or r9,r8
	mov qword [rbp-840],r9
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-408],r8
	mov r8,qword [rbp-408]
	idiv r8
	mov r8,rax
	mov qword [rbp-600],r8
	mov r8,qword [rbp-600]
	mov r9,r8
	mov qword [rbp-536],r9
	mov r8,qword [rbp-536]
	imul r8,8
	mov qword [rbp-536],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-536]
	add r9,r8
	mov qword [rbp-536],r9
	mov r8,qword [rbp-536]
	mov r8,qword [r8+8]
	mov qword [rbp-536],r8
	mov r8,qword [rbp-288]
	mov rax,r8
	cqo
	mov r8,64
	mov qword [rbp-1200],r8
	mov r8,qword [rbp-1200]
	idiv r8
	mov r8,rdx
	mov qword [rbp-528],r8
	mov r8,qword [rbp-528]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-1184],r8
	mov r8,qword [rbp-1184]
	idiv r8
	mov r8,rax
	mov qword [rbp-192],r8
	mov r8,qword [rbp-192]
	mov r9,r8
	mov qword [rbp-1280],r9
	mov r8,qword [rbp-1280]
	imul r8,8
	mov qword [rbp-1280],r8
	mov r8,qword [rbp-536]
	mov r9,qword [rbp-1280]
	add r9,r8
	mov qword [rbp-1280],r9
	mov r8,qword [rbp-1280]
	mov r9,qword [rbp-840]
	mov qword [r8+8],r9
	mov r8,qword [rbp-456]
	mov r9,r8
	mov qword [rbp-960],r9
	mov r8,qword [rbp-960]
	sal r8,3
	mov qword [rbp-960],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-256]
	sub r8,1
	mov qword [rbp-256],r8
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-168],r9
	mov r8,qword [rbp-168]
	mov r9,r8
	mov qword [rbp-432],r9
	mov r8,qword [rbp-432]
	imul r8,8
	mov qword [rbp-432],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-432]
	add r9,r8
	mov qword [rbp-432],r9
	mov r8,qword [rbp-432]
	mov r8,qword [r8+8]
	mov qword [rbp-432],r8
	mov r8,qword [rbp-432]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	add r8,120
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,qword [rbp-960]
	mov qword [r8+8],r9
	mov r8,qword [rbp-456]
	mov r9,r8
	mov qword [rbp-1064],r9
	mov r8,qword [rbp-1064]
	sar r8,29
	mov qword [rbp-1064],r8
	mov r8,qword [rbp-1064]
	mov r9,r8
	mov qword [rbp-624],r9
	mov r8,qword [rbp-624]
	and r8,7
	mov qword [rbp-624],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-480],r9
	mov r8,qword [rbp-480]
	sub r8,1
	mov qword [rbp-480],r8
	mov r8,qword [rbp-480]
	mov r9,r8
	mov qword [rbp-984],r9
	mov r8,qword [rbp-984]
	mov r9,r8
	mov qword [rbp-376],r9
	mov r8,qword [rbp-376]
	imul r8,8
	mov qword [rbp-376],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-376]
	add r9,r8
	mov qword [rbp-376],r9
	mov r8,qword [rbp-376]
	mov r8,qword [r8+8]
	mov qword [rbp-376],r8
	mov r8,qword [rbp-376]
	mov r9,r8
	mov qword [rbp-1304],r9
	mov r8,qword [rbp-1304]
	add r8,112
	mov qword [rbp-1304],r8
	mov r8,qword [rbp-1304]
	mov r9,qword [rbp-624]
	mov qword [r8+8],r9
	mov r8,1732584193
	mov qword [rbp-104],r8
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,61389
	mov rdi,43913
	call ___lohi
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-1112],r8
	mov r8,qword [rbp-1112]
	mov r9,r8
	mov qword [rbp-144],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,39098
	mov rdi,56574
	call ___lohi
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-864],r8
	mov r8,qword [rbp-864]
	mov r9,r8
	mov qword [rbp-400],r9
	mov r8,271733878
	mov qword [rbp-216],r8
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,50130
	mov rdi,57840
	call ___lohi
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-1096],r9
	mov r8,0
	mov qword [rbp-288],r8
	jmp ___sha1..for_cond_4
___sha1..for_cond_4:
	mov r8,qword [rbp-288]
	mov r9,qword [rbp-80]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-936],r10
	mov r8,qword [rbp-936]
	cmp r8b,1
	jz ___sha1..for_loop_4
	jnz ___sha1..for_after_4
___sha1..for_after_4:
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-672],r9
	mov r8,qword [rbp-672]
	add r8,0
	mov qword [rbp-672],r8
	mov r8,qword [rbp-672]
	mov r9,qword [rbp-104]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-1000],r9
	mov r8,qword [rbp-1000]
	add r8,8
	mov qword [rbp-1000],r8
	mov r8,qword [rbp-1000]
	mov r9,qword [rbp-144]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-952],r9
	mov r8,qword [rbp-952]
	add r8,16
	mov qword [rbp-952],r8
	mov r8,qword [rbp-952]
	mov r9,qword [rbp-400]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-184]
	add r8,24
	mov qword [rbp-184],r8
	mov r8,qword [rbp-184]
	mov r9,qword [rbp-216]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-776],r9
	mov r8,qword [rbp-776]
	add r8,32
	mov qword [rbp-776],r8
	mov r8,qword [rbp-776]
	mov r9,qword [rbp-1096]
	mov qword [r8+8],r9
	mov r8,qword [rbp-1160]
	mov r9,r8
	mov qword [rbp-1136],r9
	jmp ___sha1..sha1.exit
___sha1..sha1.exit:
	mov r8,qword [rbp-1136]
	mov rax,r8
	leave
	ret
___sha1..for_loop_4:
	mov r8,16
	mov qword [rbp-944],r8
	jmp ___sha1..for_cond_5
___sha1..for_cond_5:
	mov r8,qword [rbp-944]
	cmp r8,80
	mov r9,0
	setl r9b
	mov qword [rbp-1144],r9
	mov r8,qword [rbp-1144]
	cmp r8b,1
	jz ___sha1..for_loop_5
	jnz ___sha1..for_after_5
___sha1..for_after_5:
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-1176],r9
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-520],r9
	mov r8,qword [rbp-400]
	mov r9,r8
	mov qword [rbp-712],r9
	mov r8,qword [rbp-216]
	mov r9,r8
	mov qword [rbp-512],r9
	mov r8,qword [rbp-1096]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,0
	mov qword [rbp-944],r8
	jmp ___sha1..for_cond_6
___sha1..for_cond_6:
	mov r8,qword [rbp-944]
	cmp r8,80
	mov r9,0
	setl r9b
	mov qword [rbp-344],r9
	mov r8,qword [rbp-344]
	cmp r8b,1
	jz ___sha1..for_loop_6
	jnz ___sha1..for_after_6
___sha1..for_after_6:
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-1176]
	mov rdi,qword [rbp-104]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-104],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-520]
	mov rdi,qword [rbp-144]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-312],r8
	mov r8,qword [rbp-312]
	mov r9,r8
	mov qword [rbp-144],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-712]
	mov rdi,qword [rbp-400]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-1232],r8
	mov r8,qword [rbp-1232]
	mov r9,r8
	mov qword [rbp-400],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-512]
	mov rdi,qword [rbp-216]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-584],r8
	mov r8,qword [rbp-584]
	mov r9,r8
	mov qword [rbp-216],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-88]
	mov rdi,qword [rbp-1096]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-336],r8
	mov r8,qword [rbp-336]
	mov r9,r8
	mov qword [rbp-1096],r9
	jmp ___sha1..for_step_4
___sha1..for_step_4:
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-288]
	add r8,1
	mov qword [rbp-288],r8
	jmp ___sha1..for_cond_4
___sha1..for_loop_6:
	mov r8,0
	mov qword [rbp-208],r8
	mov r8,0
	mov qword [rbp-816],r8
	mov r8,qword [rbp-944]
	cmp r8,20
	mov r9,0
	setl r9b
	mov qword [rbp-320],r9
	mov r8,qword [rbp-320]
	cmp r8b,1
	jz ___sha1..if_true_2
	jnz ___sha1..if_false
___sha1..if_true_2:
	mov r8,qword [rbp-520]
	mov r9,r8
	mov qword [rbp-416],r9
	mov r8,qword [rbp-712]
	mov r9,qword [rbp-416]
	and r9,r8
	mov qword [rbp-416],r9
	mov r8,qword [rbp-520]
	mov r9,r8
	mov qword [rbp-440],r9
	mov r8,qword [rbp-440]
	not r8
	mov qword [rbp-440],r8
	mov r8,qword [rbp-440]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-264],r9
	mov r8,qword [rbp-512]
	mov r9,qword [rbp-264]
	and r9,r8
	mov qword [rbp-264],r9
	mov r8,qword [rbp-416]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-264]
	mov r9,qword [rbp-40]
	or r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,1518500249
	mov qword [rbp-816],r8
	jmp ___sha1..if_after_2
___sha1..if_false:
	mov r8,qword [rbp-944]
	cmp r8,40
	mov r9,0
	setl r9b
	mov qword [rbp-888],r9
	mov r8,qword [rbp-888]
	cmp r8b,1
	jz ___sha1..if_true_3
	jnz ___sha1..if_false_2
___sha1..if_true_3:
	mov r8,qword [rbp-520]
	mov r9,r8
	mov qword [rbp-1056],r9
	mov r8,qword [rbp-712]
	mov r9,qword [rbp-1056]
	xor r9,r8
	mov qword [rbp-1056],r9
	mov r8,qword [rbp-1056]
	mov r9,r8
	mov qword [rbp-976],r9
	mov r8,qword [rbp-512]
	mov r9,qword [rbp-976]
	xor r9,r8
	mov qword [rbp-976],r9
	mov r8,qword [rbp-976]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,1859775393
	mov qword [rbp-816],r8
	jmp ___sha1..if_after_3
___sha1..if_false_2:
	mov r8,qword [rbp-944]
	cmp r8,60
	mov r9,0
	setl r9b
	mov qword [rbp-632],r9
	mov r8,qword [rbp-632]
	cmp r8b,1
	jz ___sha1..if_true_4
	jnz ___sha1..if_false_3
___sha1..if_false_3:
	mov r8,qword [rbp-520]
	mov r9,r8
	mov qword [rbp-1296],r9
	mov r8,qword [rbp-712]
	mov r9,qword [rbp-1296]
	xor r9,r8
	mov qword [rbp-1296],r9
	mov r8,qword [rbp-1296]
	mov r9,r8
	mov qword [rbp-1152],r9
	mov r8,qword [rbp-512]
	mov r9,qword [rbp-1152]
	xor r9,r8
	mov qword [rbp-1152],r9
	mov r8,qword [rbp-1152]
	mov r9,r8
	mov qword [rbp-208],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,51810
	mov rdi,49622
	call ___lohi
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-816],r9
	jmp ___sha1..if_after_4
___sha1..if_true_4:
	mov r8,qword [rbp-520]
	mov r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-712]
	mov r9,qword [rbp-280]
	and r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-520]
	mov r9,r8
	mov qword [rbp-880],r9
	mov r8,qword [rbp-512]
	mov r9,qword [rbp-880]
	and r9,r8
	mov qword [rbp-880],r9
	mov r8,qword [rbp-280]
	mov r9,r8
	mov qword [rbp-824],r9
	mov r8,qword [rbp-880]
	mov r9,qword [rbp-824]
	or r9,r8
	mov qword [rbp-824],r9
	mov r8,qword [rbp-712]
	mov r9,r8
	mov qword [rbp-912],r9
	mov r8,qword [rbp-512]
	mov r9,qword [rbp-912]
	and r9,r8
	mov qword [rbp-912],r9
	mov r8,qword [rbp-824]
	mov r9,r8
	mov qword [rbp-1104],r9
	mov r8,qword [rbp-912]
	mov r9,qword [rbp-1104]
	or r9,r8
	mov qword [rbp-1104],r9
	mov r8,qword [rbp-1104]
	mov r9,r8
	mov qword [rbp-208],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,36635
	mov rdi,48348
	call ___lohi
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-240],r8
	mov r8,qword [rbp-240]
	mov r9,r8
	mov qword [rbp-816],r9
	jmp ___sha1..if_after_4
___sha1..if_after_4:
	jmp ___sha1..if_after_3
___sha1..if_after_3:
	jmp ___sha1..if_after_2
___sha1..if_after_2:
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,5
	mov rdi,qword [rbp-1176]
	call ___rotate_left
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-552],r8
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-88]
	mov rdi,qword [rbp-552]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-464],r8
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-816]
	mov rdi,qword [rbp-208]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-136],r8
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-136]
	mov rdi,qword [rbp-464]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-1008],r8
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-664],r9
	mov r8,qword [rbp-664]
	imul r8,8
	mov qword [rbp-664],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-664]
	add r9,r8
	mov qword [rbp-664],r9
	mov r8,qword [rbp-664]
	mov r8,qword [r8+8]
	mov qword [rbp-664],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-1040],r9
	mov r8,qword [rbp-1040]
	imul r8,8
	mov qword [rbp-1040],r8
	mov r8,qword [rbp-664]
	mov r9,qword [rbp-1040]
	add r9,r8
	mov qword [rbp-1040],r9
	mov r8,qword [rbp-1040]
	mov r8,qword [r8+8]
	mov qword [rbp-1040],r8
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,qword [rbp-1040]
	mov rdi,qword [rbp-1008]
	call ___add
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-304],r8
	mov r8,qword [rbp-304]
	mov r9,r8
	mov qword [rbp-1088],r9
	mov r8,qword [rbp-512]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-712]
	mov r9,r8
	mov qword [rbp-512],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,30
	mov rdi,qword [rbp-520]
	call ___rotate_left
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-504],r8
	mov r8,qword [rbp-504]
	mov r9,r8
	mov qword [rbp-712],r9
	mov r8,qword [rbp-1176]
	mov r9,r8
	mov qword [rbp-520],r9
	mov r8,qword [rbp-1088]
	mov r9,r8
	mov qword [rbp-1176],r9
	jmp ___sha1..for_step_5
___sha1..for_step_5:
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-920],r9
	mov r8,qword [rbp-944]
	add r8,1
	mov qword [rbp-944],r8
	jmp ___sha1..for_cond_6
___sha1..for_loop_5:
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-232]
	imul r8,8
	mov qword [rbp-232],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-232]
	add r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-232]
	mov r8,qword [r8+8]
	mov qword [rbp-232],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-792],r9
	mov r8,qword [rbp-792]
	sub r8,3
	mov qword [rbp-792],r8
	mov r8,qword [rbp-792]
	mov r9,r8
	mov qword [rbp-992],r9
	mov r8,qword [rbp-992]
	mov r9,r8
	mov qword [rbp-544],r9
	mov r8,qword [rbp-544]
	imul r8,8
	mov qword [rbp-544],r8
	mov r8,qword [rbp-232]
	mov r9,qword [rbp-544]
	add r9,r8
	mov qword [rbp-544],r9
	mov r8,qword [rbp-544]
	mov r8,qword [r8+8]
	mov qword [rbp-544],r8
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-576],r9
	mov r8,qword [rbp-576]
	imul r8,8
	mov qword [rbp-576],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-576]
	add r9,r8
	mov qword [rbp-576],r9
	mov r8,qword [rbp-576]
	mov r8,qword [r8+8]
	mov qword [rbp-576],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-1168],r9
	mov r8,qword [rbp-1168]
	sub r8,8
	mov qword [rbp-1168],r8
	mov r8,qword [rbp-1168]
	mov r9,r8
	mov qword [rbp-1272],r9
	mov r8,qword [rbp-1272]
	mov r9,r8
	mov qword [rbp-896],r9
	mov r8,qword [rbp-896]
	imul r8,8
	mov qword [rbp-896],r8
	mov r8,qword [rbp-576]
	mov r9,qword [rbp-896]
	add r9,r8
	mov qword [rbp-896],r9
	mov r8,qword [rbp-896]
	mov r8,qword [r8+8]
	mov qword [rbp-896],r8
	mov r8,qword [rbp-544]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-896]
	mov r9,qword [rbp-128]
	xor r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-496],r9
	mov r8,qword [rbp-496]
	imul r8,8
	mov qword [rbp-496],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-496]
	add r9,r8
	mov qword [rbp-496],r9
	mov r8,qword [rbp-496]
	mov r8,qword [r8+8]
	mov qword [rbp-496],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-200]
	sub r8,14
	mov qword [rbp-200],r8
	mov r8,qword [rbp-200]
	mov r9,r8
	mov qword [rbp-384],r9
	mov r8,qword [rbp-384]
	mov r9,r8
	mov qword [rbp-688],r9
	mov r8,qword [rbp-688]
	imul r8,8
	mov qword [rbp-688],r8
	mov r8,qword [rbp-496]
	mov r9,qword [rbp-688]
	add r9,r8
	mov qword [rbp-688],r9
	mov r8,qword [rbp-688]
	mov r8,qword [r8+8]
	mov qword [rbp-688],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-560],r9
	mov r8,qword [rbp-688]
	mov r9,qword [rbp-560]
	xor r9,r8
	mov qword [rbp-560],r9
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-1192],r9
	mov r8,qword [rbp-1192]
	imul r8,8
	mov qword [rbp-1192],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-1192]
	add r9,r8
	mov qword [rbp-1192],r9
	mov r8,qword [rbp-1192]
	mov r8,qword [r8+8]
	mov qword [rbp-1192],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-160],r9
	mov r8,qword [rbp-160]
	sub r8,16
	mov qword [rbp-160],r8
	mov r8,qword [rbp-160]
	mov r9,r8
	mov qword [rbp-568],r9
	mov r8,qword [rbp-568]
	mov r9,r8
	mov qword [rbp-1288],r9
	mov r8,qword [rbp-1288]
	imul r8,8
	mov qword [rbp-1288],r8
	mov r8,qword [rbp-1192]
	mov r9,qword [rbp-1288]
	add r9,r8
	mov qword [rbp-1288],r9
	mov r8,qword [rbp-1288]
	mov r8,qword [r8+8]
	mov qword [rbp-1288],r8
	mov r8,qword [rbp-560]
	mov r9,r8
	mov qword [rbp-368],r9
	mov r8,qword [rbp-1288]
	mov r9,qword [rbp-368]
	xor r9,r8
	mov qword [rbp-368],r9
	mov qword [rbp-1320],r8
	mov qword [rbp-1336],r9
	mov qword [rbp-1344],rdi
	mov qword [rbp-1352],rsi
	mov rsi,1
	mov rdi,qword [rbp-368]
	call ___rotate_left
	mov rsi,qword [rbp-1352]
	mov rdi,qword [rbp-1344]
	mov r9,qword [rbp-1336]
	mov r8,qword [rbp-1320]
	mov r8,rax
	mov qword [rbp-1264],r8
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-968],r9
	mov r8,qword [rbp-968]
	imul r8,8
	mov qword [rbp-968],r8
	mov r8,qword [rbp-728]
	mov r9,qword [rbp-968]
	add r9,r8
	mov qword [rbp-968],r9
	mov r8,qword [rbp-968]
	mov r8,qword [r8+8]
	mov qword [rbp-968],r8
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-1224],r9
	mov r8,qword [rbp-1224]
	imul r8,8
	mov qword [rbp-1224],r8
	mov r8,qword [rbp-968]
	mov r9,qword [rbp-1224]
	add r9,r8
	mov qword [rbp-1224],r9
	mov r8,qword [rbp-1224]
	mov r9,qword [rbp-1264]
	mov qword [r8+8],r9
	jmp ___sha1..for_step_6
___sha1..for_step_6:
	mov r8,qword [rbp-944]
	mov r9,r8
	mov qword [rbp-848],r9
	mov r8,qword [rbp-944]
	add r8,1
	mov qword [rbp-944],r8
	jmp ___sha1..for_cond_5

___computeSHA1:
___computeSHA1..computeSHA1.entry:
	push rbp
	mov rbp,rsp
	sub rsp,208
	mov qword [rbp-104],rdi
	mov r8,___string
	mov qword [rbp-56],r8
	mov r8,qword [___inputBuffer]
	mov qword [rbp-16],r8
	mov r8,0
	mov qword [rbp-120],r8
	mov r8,0
	mov qword [rbp-120],r8
	jmp ___computeSHA1..for_cond
___computeSHA1..for_cond:
	mov r8,qword [rbp-104]
	mov r9,qword [r8]
	mov qword [rbp-80],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-80]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-96],r10
	mov r8,qword [rbp-96]
	cmp r8b,1
	jz ___computeSHA1..for_loop
	jnz ___computeSHA1..for_after
___computeSHA1..for_after:
	mov r8,qword [rbp-104]
	mov r9,qword [r8]
	mov qword [rbp-32],r9
	mov qword [rbp-144],r8
	mov qword [rbp-152],r10
	mov qword [rbp-160],r9
	mov qword [rbp-168],rdi
	mov qword [rbp-176],rsi
	mov rsi,qword [rbp-32]
	mov rdi,qword [rbp-16]
	call ___sha1
	mov rsi,qword [rbp-176]
	mov rdi,qword [rbp-168]
	mov r9,qword [rbp-160]
	mov r10,qword [rbp-152]
	mov r8,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-136],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,0
	mov qword [rbp-120],r8
	jmp ___computeSHA1..for_cond_2
___computeSHA1..for_cond_2:
	mov r8,qword [rbp-88]
	mov r9,qword [r8]
	mov qword [rbp-24],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-24]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-40],r10
	mov r8,qword [rbp-40]
	cmp r8b,1
	jz ___computeSHA1..for_loop_2
	jnz ___computeSHA1..for_after_2
___computeSHA1..for_after_2:
	mov qword [rbp-144],r8
	mov qword [rbp-152],r10
	mov qword [rbp-160],r9
	mov rdi,qword [rbp-56]
	call _Z7printlnPc
	mov r9,qword [rbp-160]
	mov r10,qword [rbp-152]
	mov r8,qword [rbp-144]
	leave
	ret
___computeSHA1..for_loop_2:
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	imul r8,8
	mov qword [rbp-128],r8
	mov r8,qword [rbp-88]
	mov r9,qword [rbp-128]
	add r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	mov r8,qword [r8+8]
	mov qword [rbp-128],r8
	mov qword [rbp-144],r8
	mov qword [rbp-160],r9
	mov qword [rbp-168],rdi
	mov rdi,qword [rbp-128]
	call ___toStringHex
	mov rdi,qword [rbp-168]
	mov r9,qword [rbp-160]
	mov r8,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-48],r8
	mov r8,___string
	mov qword [rbp-56],r8
	mov qword [rbp-144],r8
	mov qword [rbp-152],r10
	mov qword [rbp-160],r9
	mov rdi,qword [rbp-48]
	call _Z5printPc
	mov r9,qword [rbp-160]
	mov r10,qword [rbp-152]
	mov r8,qword [rbp-144]
	jmp ___computeSHA1..for_step
___computeSHA1..for_step:
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-120]
	add r8,1
	mov qword [rbp-120],r8
	jmp ___computeSHA1..for_cond_2
___computeSHA1..for_loop:
	mov qword [rbp-144],r8
	mov qword [rbp-152],r10
	mov qword [rbp-160],r9
	mov rsi,qword [rbp-120]
	mov rdi,qword [rbp-104]
	call _Z9stringOrdPci
	mov r9,qword [rbp-160]
	mov r10,qword [rbp-152]
	mov r8,qword [rbp-144]
	mov r8,rax
	mov qword [rbp-112],r8
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	imul r8,8
	mov qword [rbp-64],r8
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-64]
	add r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-112]
	mov qword [r8+8],r9
	jmp ___computeSHA1..for_step_2
___computeSHA1..for_step_2:
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-120]
	add r8,1
	mov qword [rbp-120],r8
	jmp ___computeSHA1..for_cond

___nextLetter:
___nextLetter..nextLetter.entry:
	push rbp
	mov rbp,rsp
	sub rsp,128
	mov qword [rbp-48],rdi
	mov r8,qword [rbp-48]
	cmp r8,122
	mov r9,0
	sete r9b
	mov qword [rbp-56],r9
	mov r8,qword [rbp-56]
	cmp r8b,1
	jz ___nextLetter..if_true
	jnz ___nextLetter..if_after
___nextLetter..if_after:
	mov r8,qword [rbp-48]
	cmp r8,90
	mov r9,0
	sete r9b
	mov qword [rbp-24],r9
	mov r8,qword [rbp-24]
	cmp r8b,1
	jz ___nextLetter..if_true_2
	jnz ___nextLetter..if_after_2
___nextLetter..if_true_2:
	mov r8,97
	mov qword [rbp-16],r8
	jmp ___nextLetter..nextLetter.exit
___nextLetter..if_after_2:
	mov r8,qword [rbp-48]
	cmp r8,57
	mov r9,0
	sete r9b
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	cmp r8b,1
	jz ___nextLetter..if_true_3
	jnz ___nextLetter..if_after_3
___nextLetter..if_true_3:
	mov r8,65
	mov qword [rbp-16],r8
	jmp ___nextLetter..nextLetter.exit
___nextLetter..if_after_3:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	add r8,1
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-16],r9
	jmp ___nextLetter..nextLetter.exit
___nextLetter..if_true:
	mov r8,-1
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-16],r9
	jmp ___nextLetter..nextLetter.exit
___nextLetter..nextLetter.exit:
	mov r8,qword [rbp-16]
	mov rax,r8
	leave
	ret

___nextText:
___nextText..nextText.entry:
	push rbp
	mov rbp,rsp
	sub rsp,208
	mov qword [rbp-64],rdi
	mov qword [rbp-24],rsi
	mov r8,0
	mov qword [rbp-48],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	sub r8,1
	mov qword [rbp-80],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-48],r9
	jmp ___nextText..for_cond
___nextText..for_cond:
	mov r8,qword [rbp-48]
	cmp r8,0
	mov r9,0
	setge r9b
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	cmp r8b,1
	jz ___nextText..for_loop
	jnz ___nextText..for_after
___nextText..for_loop:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	imul r8,8
	mov qword [rbp-128],r8
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-128]
	add r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	mov r8,qword [r8+8]
	mov qword [rbp-128],r8
	mov qword [rbp-136],r8
	mov qword [rbp-152],r9
	mov qword [rbp-160],rdi
	mov rdi,qword [rbp-128]
	call ___nextLetter
	mov rdi,qword [rbp-160]
	mov r9,qword [rbp-152]
	mov r8,qword [rbp-136]
	mov r8,rax
	mov qword [rbp-88],r8
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	imul r8,8
	mov qword [rbp-32],r8
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-32]
	add r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-88]
	mov qword [r8+8],r9
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	imul r8,8
	mov qword [rbp-96],r8
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-96]
	add r9,r8
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	mov r8,qword [r8+8]
	mov qword [rbp-96],r8
	mov r8,-1
	mov qword [rbp-104],r8
	mov r8,qword [rbp-96]
	mov r9,qword [rbp-104]
	cmp r8,r9
	mov r10,0
	sete r10b
	mov qword [rbp-56],r10
	mov r8,qword [rbp-56]
	cmp r8b,1
	jz ___nextText..if_true
	jnz ___nextText..if_false
___nextText..if_true:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	imul r8,8
	mov qword [rbp-120],r8
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-120]
	add r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	mov qword [r8+8],48
	jmp ___nextText..if_after
___nextText..if_after:
	jmp ___nextText..for_step
___nextText..for_step:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	sub r8,1
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-48],r9
	jmp ___nextText..for_cond
___nextText..if_false:
	mov r8,1
	mov qword [rbp-112],r8
	jmp ___nextText..nextText.exit
___nextText..for_after:
	mov r8,0
	mov qword [rbp-112],r8
	jmp ___nextText..nextText.exit
___nextText..nextText.exit:
	mov r8,qword [rbp-112]
	mov rax,r8
	leave
	ret

___array_equal:
___array_equal..array_equal.entry:
	push rbp
	mov rbp,rsp
	sub rsp,176
	mov qword [rbp-40],rdi
	mov qword [rbp-88],rsi
	mov r8,qword [rbp-40]
	mov r9,qword [r8]
	mov qword [rbp-104],r9
	mov r8,qword [rbp-88]
	mov r9,qword [r8]
	mov qword [rbp-96],r9
	mov r8,qword [rbp-104]
	mov r9,qword [rbp-96]
	cmp r8,r9
	mov r10,0
	setne r10b
	mov qword [rbp-8],r10
	mov r8,qword [rbp-8]
	cmp r8b,1
	jz ___array_equal..if_true
	jnz ___array_equal..if_after
___array_equal..if_after:
	mov r8,0
	mov qword [rbp-48],r8
	mov r8,0
	mov qword [rbp-48],r8
	jmp ___array_equal..for_cond
___array_equal..for_cond:
	mov r8,qword [rbp-40]
	mov r9,qword [r8]
	mov qword [rbp-32],r9
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-32]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-24],r10
	mov r8,qword [rbp-24]
	cmp r8b,1
	jz ___array_equal..for_loop
	jnz ___array_equal..for_after
___array_equal..for_loop:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	imul r8,8
	mov qword [rbp-64],r8
	mov r8,qword [rbp-40]
	mov r9,qword [rbp-64]
	add r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	mov r8,qword [r8+8]
	mov qword [rbp-64],r8
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	imul r8,8
	mov qword [rbp-16],r8
	mov r8,qword [rbp-88]
	mov r9,qword [rbp-16]
	add r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	mov r8,qword [r8+8]
	mov qword [rbp-16],r8
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-16]
	cmp r8,r9
	mov r10,0
	setne r10b
	mov qword [rbp-56],r10
	mov r8,qword [rbp-56]
	cmp r8b,1
	jz ___array_equal..if_true_2
	jnz ___array_equal..if_after_2
___array_equal..if_true_2:
	mov r8,0
	mov qword [rbp-80],r8
	jmp ___array_equal..array_equal.exit
___array_equal..if_after_2:
	jmp ___array_equal..for_step
___array_equal..for_step:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-48]
	add r8,1
	mov qword [rbp-48],r8
	jmp ___array_equal..for_cond
___array_equal..for_after:
	mov r8,1
	mov qword [rbp-80],r8
	jmp ___array_equal..array_equal.exit
___array_equal..if_true:
	mov r8,0
	mov qword [rbp-80],r8
	jmp ___array_equal..array_equal.exit
___array_equal..array_equal.exit:
	mov r8,qword [rbp-80]
	mov rax,r8
	leave
	ret

___crackSHA1:
___crackSHA1..crackSHA1.entry:
	push rbp
	mov rbp,rsp
	sub rsp,464
	mov qword [rbp-16],rdi
	mov r8,___string_3
	mov qword [rbp-88],r8
	mov r8,___string
	mov qword [rbp-64],r8
	mov r8,___string_4
	mov qword [rbp-264],r8
	mov r8,qword [___inputBuffer]
	mov qword [rbp-144],r8
	mov r8,48
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov rdi,r8
	call malloc
	mov rdi,qword [rbp-16]
	mov r8,rax
	mov qword [rbp-56],r8
	mov qword [rbp-16],rdi
	mov r8,qword [rbp-56]
	mov qword [r8],5
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-240],r9
	mov r8,qword [rbp-16]
	mov r9,qword [r8]
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	cmp r8,40
	mov r9,0
	setne r9b
	mov qword [rbp-168],r9
	mov r8,qword [rbp-168]
	cmp r8b,1
	jz ___crackSHA1..if_true
	jnz ___crackSHA1..if_after
___crackSHA1..if_after:
	mov r8,0
	mov qword [rbp-152],r8
	mov r8,0
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond
___crackSHA1..for_cond:
	mov r8,qword [rbp-152]
	cmp r8,5
	mov r9,0
	setl r9b
	mov qword [rbp-328],r9
	mov r8,qword [rbp-328]
	cmp r8b,1
	jz ___crackSHA1..for_loop
	jnz ___crackSHA1..for_after
___crackSHA1..for_after:
	mov r8,0
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond_2
___crackSHA1..for_cond_2:
	mov r8,qword [rbp-152]
	cmp r8,40
	mov r9,0
	setl r9b
	mov qword [rbp-336],r9
	mov r8,qword [rbp-336]
	cmp r8b,1
	jz ___crackSHA1..for_loop_2
	jnz ___crackSHA1..for_after_2
___crackSHA1..for_loop_2:
	mov r8,qword [rbp-152]
	mov rax,r8
	cqo
	mov r8,8
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	idiv r8
	mov r8,rax
	mov qword [rbp-160],r8
	mov r8,qword [rbp-160]
	mov r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-280]
	imul r8,8
	mov qword [rbp-280],r8
	mov r8,qword [rbp-240]
	mov r9,qword [rbp-280]
	add r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-280]
	mov r8,qword [r8+8]
	mov qword [rbp-280],r8
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-112]
	add r8,3
	mov qword [rbp-112],r8
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov rdx,qword [rbp-112]
	mov rsi,qword [rbp-152]
	mov rdi,qword [rbp-16]
	call _Z15stringSubStringPcii
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	mov r8,rax
	mov qword [rbp-376],r8
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov qword [rbp-424],rdi
	mov rdi,qword [rbp-376]
	call ___hex2int
	mov rdi,qword [rbp-424]
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	mov r8,rax
	mov qword [rbp-192],r8
	mov r8,qword [rbp-152]
	mov rax,r8
	cqo
	mov r8,4
	mov qword [rbp-360],r8
	mov r8,qword [rbp-360]
	idiv r8
	mov r8,rax
	mov qword [rbp-392],r8
	mov r8,qword [rbp-392]
	mov rax,r8
	cqo
	mov r8,2
	mov qword [rbp-272],r8
	mov r8,qword [rbp-272]
	idiv r8
	mov r8,rdx
	mov qword [rbp-312],r8
	mov r8,1
	mov qword [rbp-368],r8
	mov r8,qword [rbp-312]
	mov r9,qword [rbp-368]
	sub r9,r8
	mov qword [rbp-368],r9
	mov r8,qword [rbp-368]
	mov r9,r8
	mov qword [rbp-296],r9
	mov r8,qword [rbp-296]
	mov r9,r8
	mov qword [rbp-344],r9
	mov r8,qword [rbp-344]
	imul r8,16
	mov qword [rbp-344],r8
	mov r8,qword [rbp-192]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-344]
	mov rcx,r8
	mov r8,qword [rbp-136]
	sal r8,cl
	mov qword [rbp-136],r8
	mov r8,qword [rbp-280]
	mov r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-136]
	mov r9,qword [rbp-232]
	or r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-152]
	mov rax,r8
	cqo
	mov r8,8
	mov qword [rbp-72],r8
	mov r8,qword [rbp-72]
	idiv r8
	mov r8,rax
	mov qword [rbp-224],r8
	mov r8,qword [rbp-224]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-48]
	imul r8,8
	mov qword [rbp-48],r8
	mov r8,qword [rbp-240]
	mov r9,qword [rbp-48]
	add r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-232]
	mov qword [r8+8],r9
	jmp ___crackSHA1..for_step
___crackSHA1..for_step:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-176],r9
	mov r8,qword [rbp-176]
	add r8,4
	mov qword [rbp-176],r8
	mov r8,qword [rbp-176]
	mov r9,r8
	mov qword [rbp-152],r9
	jmp ___crackSHA1..for_cond_2
___crackSHA1..for_after_2:
	mov r8,4
	mov qword [rbp-184],r8
	mov r8,0
	mov qword [rbp-248],r8
	mov r8,1
	mov qword [rbp-248],r8
	jmp ___crackSHA1..for_cond_3
___crackSHA1..for_cond_3:
	mov r8,qword [rbp-248]
	mov r9,qword [rbp-184]
	cmp r8,r9
	mov r10,0
	setle r10b
	mov qword [rbp-8],r10
	mov r8,qword [rbp-8]
	cmp r8b,1
	jz ___crackSHA1..for_loop_3
	jnz ___crackSHA1..for_after_3
___crackSHA1..for_after_3:
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov rdi,qword [rbp-88]
	call _Z7printlnPc
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	jmp ___crackSHA1..crackSHA1.exit
___crackSHA1..for_loop_3:
	mov r8,0
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond_4
___crackSHA1..for_cond_4:
	mov r8,qword [rbp-152]
	mov r9,qword [rbp-248]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-24],r10
	mov r8,qword [rbp-24]
	cmp r8b,1
	jz ___crackSHA1..for_loop_4
	jnz ___crackSHA1..for_after_4
___crackSHA1..for_after_4:
	jmp ___crackSHA1..while_cond
___crackSHA1..while_cond:
	jmp ___crackSHA1..while_loop
___crackSHA1..while_loop:
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov qword [rbp-424],rdi
	mov qword [rbp-432],rsi
	mov rsi,qword [rbp-248]
	mov rdi,qword [rbp-144]
	call ___sha1
	mov rsi,qword [rbp-432]
	mov rdi,qword [rbp-424]
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	mov r8,rax
	mov qword [rbp-96],r8
	mov r8,qword [rbp-96]
	mov r9,r8
	mov qword [rbp-120],r9
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov qword [rbp-424],rdi
	mov qword [rbp-432],rsi
	mov rsi,qword [rbp-240]
	mov rdi,qword [rbp-120]
	call ___array_equal
	mov rsi,qword [rbp-432]
	mov rdi,qword [rbp-424]
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	mov r8,rax
	mov qword [rbp-352],r8
	mov r8,qword [rbp-352]
	cmp r8b,1
	jz ___crackSHA1..if_true_2
	jnz ___crackSHA1..if_after_2
___crackSHA1..if_true_2:
	mov r8,0
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond_5
___crackSHA1..for_cond_5:
	mov r8,qword [rbp-152]
	mov r9,qword [rbp-248]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-200],r10
	mov r8,qword [rbp-200]
	cmp r8b,1
	jz ___crackSHA1..for_loop_5
	jnz ___crackSHA1..for_after_5
___crackSHA1..for_loop_5:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,qword [rbp-208]
	imul r8,8
	mov qword [rbp-208],r8
	mov r8,qword [rbp-144]
	mov r9,qword [rbp-208]
	add r9,r8
	mov qword [rbp-208],r9
	mov r8,qword [rbp-208]
	mov r8,qword [r8+8]
	mov qword [rbp-208],r8
	mov qword [rbp-400],r8
	mov qword [rbp-416],r9
	mov qword [rbp-424],rdi
	mov rdi,qword [rbp-208]
	call ___int2chr
	mov rdi,qword [rbp-424]
	mov r9,qword [rbp-416]
	mov r8,qword [rbp-400]
	mov r8,rax
	mov qword [rbp-128],r8
	mov r8,___string
	mov qword [rbp-64],r8
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov rdi,qword [rbp-128]
	call _Z5printPc
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	jmp ___crackSHA1..for_step_2
___crackSHA1..for_step_2:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-288],r9
	mov r8,qword [rbp-152]
	add r8,1
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond_5
___crackSHA1..for_after_5:
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov rdi,qword [rbp-64]
	call _Z7printlnPc
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	jmp ___crackSHA1..crackSHA1.exit
___crackSHA1..if_after_2:
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov qword [rbp-424],rdi
	mov qword [rbp-432],rsi
	mov rsi,qword [rbp-248]
	mov rdi,qword [rbp-144]
	call ___nextText
	mov rsi,qword [rbp-432]
	mov rdi,qword [rbp-424]
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	mov r8,rax
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-104]
	xor r8,1
	mov qword [rbp-104],r8
	mov r8,qword [rbp-104]
	cmp r8b,1
	jz ___crackSHA1..if_true_3
	jnz ___crackSHA1..if_after_3
___crackSHA1..if_after_3:
	jmp ___crackSHA1..while_cond
___crackSHA1..if_true_3:
	jmp ___crackSHA1..while_after
___crackSHA1..while_after:
	jmp ___crackSHA1..for_step_3
___crackSHA1..for_step_3:
	mov r8,qword [rbp-248]
	mov r9,r8
	mov qword [rbp-304],r9
	mov r8,qword [rbp-248]
	add r8,1
	mov qword [rbp-248],r8
	jmp ___crackSHA1..for_cond_3
___crackSHA1..for_loop_4:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-384],r9
	mov r8,qword [rbp-384]
	imul r8,8
	mov qword [rbp-384],r8
	mov r8,qword [rbp-144]
	mov r9,qword [rbp-384]
	add r9,r8
	mov qword [rbp-384],r9
	mov r8,qword [rbp-384]
	mov qword [r8+8],48
	jmp ___crackSHA1..for_step_4
___crackSHA1..for_step_4:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-320],r9
	mov r8,qword [rbp-152]
	add r8,1
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond_4
___crackSHA1..for_loop:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-216]
	imul r8,8
	mov qword [rbp-216],r8
	mov r8,qword [rbp-240]
	mov r9,qword [rbp-216]
	add r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-216]
	mov qword [r8+8],0
	jmp ___crackSHA1..for_step_5
___crackSHA1..for_step_5:
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-152]
	add r8,1
	mov qword [rbp-152],r8
	jmp ___crackSHA1..for_cond
___crackSHA1..if_true:
	mov qword [rbp-400],r8
	mov qword [rbp-408],r10
	mov qword [rbp-416],r9
	mov rdi,qword [rbp-264]
	call _Z7printlnPc
	mov r9,qword [rbp-416]
	mov r10,qword [rbp-408]
	mov r8,qword [rbp-400]
	jmp ___crackSHA1..crackSHA1.exit
___crackSHA1..crackSHA1.exit:
	leave
	ret

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,144
	mov qword [rbp-88],r8
	mov qword [rbp-96],r9
	call ____init
	mov r9,qword [rbp-96]
	mov r8,qword [rbp-88]
	mov r8,0
	mov qword [rbp-16],r8
	mov r8,0
	mov qword [rbp-48],r8
	jmp main..while_cond
main..while_cond:
	jmp main..while_loop
main..while_loop:
	mov qword [rbp-88],r8
	mov qword [rbp-96],r9
	call _Z6getIntv
	mov r9,qword [rbp-96]
	mov r8,qword [rbp-88]
	mov r8,rax
	mov qword [rbp-56],r8
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	cmp r8,0
	mov r9,0
	sete r9b
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	cmp r8b,1
	jz main..if_true
	jnz main..if_after
main..if_after:
	mov r8,qword [rbp-16]
	cmp r8,1
	mov r9,0
	sete r9b
	mov qword [rbp-8],r9
	mov r8,qword [rbp-8]
	cmp r8b,1
	jz main..if_true_2
	jnz main..if_false
main..if_false:
	mov r8,qword [rbp-16]
	cmp r8,2
	mov r9,0
	sete r9b
	mov qword [rbp-64],r9
	mov r8,qword [rbp-64]
	cmp r8b,1
	jz main..if_true_3
	jnz main..if_after_2
main..if_true_3:
	mov qword [rbp-88],r8
	mov qword [rbp-96],r9
	call _Z9getStringv
	mov r9,qword [rbp-96]
	mov r8,qword [rbp-88]
	mov r8,rax
	mov qword [rbp-80],r8
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-48],r9
	mov qword [rbp-88],r8
	mov qword [rbp-96],r9
	mov qword [rbp-104],rdi
	mov rdi,qword [rbp-48]
	call ___crackSHA1
	mov rdi,qword [rbp-104]
	mov r9,qword [rbp-96]
	mov r8,qword [rbp-88]
	mov r8,rax
	mov qword [rbp-40],r8
	jmp main..if_after_2
main..if_after_2:
	jmp main..if_after_3
main..if_true_2:
	mov qword [rbp-88],r8
	mov qword [rbp-96],r9
	call _Z9getStringv
	mov r9,qword [rbp-96]
	mov r8,qword [rbp-88]
	mov r8,rax
	mov qword [rbp-32],r8
	mov r8,qword [rbp-32]
	mov r9,r8
	mov qword [rbp-48],r9
	mov qword [rbp-88],r8
	mov qword [rbp-96],r9
	mov qword [rbp-104],rdi
	mov rdi,qword [rbp-48]
	call ___computeSHA1
	mov rdi,qword [rbp-104]
	mov r9,qword [rbp-96]
	mov r8,qword [rbp-88]
	mov r8,rax
	mov qword [rbp-24],r8
	jmp main..if_after_3
main..if_after_3:
	jmp main..while_cond
main..if_true:
	jmp main..while_after
main..while_after:
	mov rax,0
	leave
	ret

____init:
____init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,224
	mov r8,qword [___asciiTable]
	mov qword [rbp-104],r8
	mov r8,qword [___chunks]
	mov qword [rbp-88],r8
	mov r8,qword [___MAXCHUNK]
	mov qword [rbp-8],r8
	mov r8,___string_5
	mov qword [rbp-24],r8
	mov r8,qword [___MAXLENGTH]
	mov qword [rbp-152],r8
	mov r8,qword [___outputBuffer]
	mov qword [rbp-112],r8
	mov r8,qword [___inputBuffer]
	mov qword [rbp-32],r8
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,100
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	sub r8,1
	mov qword [rbp-128],r8
	mov r8,qword [rbp-128]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,qword [rbp-80]
	mov r9,r8
	mov qword [rbp-136],r9
	mov r8,qword [rbp-136]
	imul r8,64
	mov qword [rbp-136],r8
	mov r8,qword [rbp-136]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-16]
	sub r8,16
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-48]
	imul r8,8
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	add r8,8
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-48],r8
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-8]
	mov qword [r8],r9
	mov r8,0
	mov qword [rbp-56],r8
	jmp ____init..for_cond
____init..for_cond:
	mov r8,qword [rbp-56]
	mov r9,qword [rbp-8]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-96],r10
	mov r8,qword [rbp-96]
	cmp r8b,1
	jz ____init..for_loop
	jnz ____init..for_after
____init..for_after:
	mov r8,qword [rbp-48]
	mov r9,r8
	mov qword [rbp-88],r9
	mov r8,qword [rbp-152]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	imul r8,8
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	add r8,8
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-144],r8
	mov r8,qword [rbp-144]
	mov r9,qword [rbp-152]
	mov qword [r8],r9
	mov r8,qword [rbp-144]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,48
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-40],r8
	mov r8,qword [rbp-40]
	mov qword [r8],5
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-104]
	mov qword [___asciiTable],r8
	mov r8,qword [rbp-88]
	mov qword [___chunks],r8
	mov r8,qword [rbp-8]
	mov qword [___MAXCHUNK],r8
	mov r8,qword [rbp-152]
	mov qword [___MAXLENGTH],r8
	mov r8,qword [rbp-112]
	mov qword [___outputBuffer],r8
	mov r8,qword [rbp-32]
	mov qword [___inputBuffer],r8
	leave
	ret
____init..for_loop:
	mov r8,648
	mov qword [rbp-64],r8
	mov r8,qword [rbp-64]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-64],r8
	mov r8,qword [rbp-64]
	mov qword [r8],80
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	imul r8,8
	mov qword [rbp-120],r8
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-120]
	add r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-120]
	mov r9,qword [rbp-64]
	mov qword [r8+8],r9
	jmp ____init..for_step
____init..for_step:
	mov r8,qword [rbp-56]
	add r8,1
	mov qword [rbp-56],r8
	jmp ____init..for_cond

	section .data
___string_5:
	db 95,0,0,0,0,0,0,0,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,0
___string:
	db 0,0,0,0,0,0,0,0,0
___string_2:
	db 18,0,0,0,0,0,0,0,110,67,104,117,110,107,32,62,32,77,65,88,67,72,85,78,75,33,0
___string_4:
	db 13,0,0,0,0,0,0,0,73,110,118,97,108,105,100,32,105,110,112,117,116,0
___string_3:
	db 10,0,0,0,0,0,0,0,78,111,116,32,70,111,117,110,100,33,0

section .bss
___asciiTable:
	resb 64
___MAXCHUNK:
	resb 64
___MAXLENGTH:
	resb 64
___chunks:
	resb 64
___inputBuffer:
	resb 64
___outputBuffer:
	resb 64






default rel

global _Z15stringSubStringPcii
global _Z14stringParseIntPc
global _Z12stringConcatPcS_
global _Z9stringEquPcS_
global _Z10stringLessPcS_
global _Z9stringLeqPcS_
global _Z9stringOrdPci
global _Z5printPc
global _Z7printlnPc
global _Z8printInti
global _Z10printlnInti
global _Z9getStringv
global _Z6getIntv
global _Z8toStringi

extern _IO_getc
extern stdin
extern scanf
extern __stack_chk_fail
extern _IO_putc
extern stdout
extern puts
extern __printf_chk
extern strcmp
extern memcpy
extern malloc


SECTION .text

_Z15stringSubStringPcii:
        push    r15
        push    r14
        push    r13
        movsxd  r13, esi
        push    r12
        push    rbp
        push    rbx
        mov     ebx, edx
        sub     ebx, r13d
        mov     r12, rdi
        lea     edi, [rbx+0AH]
        lea     r15d, [rbx+1H]
        sub     rsp, 8
        movsxd  rdi, edi
        movsxd  r14, r15d
        call    malloc
        test    r15d, r15d
        mov     rbp, rax
        mov     qword [rax], r14
        jle     L_001
        mov     edx, ebx
        lea     rdi, [rax+8H]
        lea     rsi, [r12+r13+8H]
        add     rdx, 1
        call    memcpy
L_001:  mov     byte [rbp+r14+8H], 0
        add     rsp, 8
        mov     rax, rbp
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret







ALIGN   16

_Z14stringParseIntPc:
        xor     edx, edx
        cmp     byte [rdi+8H], 45
        sete    dl
        setne   r8b
        sete    al
        movsx   edx, byte [rdi+rdx+8H]
        movzx   r8d, r8b
        movzx   eax, al
        lea     r8d, [r8+r8-1H]
        lea     ecx, [rdx-30H]
        cmp     cl, 9
        ja      L_003
        lea     rcx, [rdi+rax+9H]
        xor     eax, eax
L_002:  lea     esi, [rax+rax*4]
        add     rcx, 1
        lea     eax, [rdx+rsi*2-30H]
        movsx   edx, byte [rcx-1H]
        lea     esi, [rdx-30H]
        cmp     sil, 9
        jbe     L_002
        imul    eax, r8d
        ret

L_003:  xor     eax, eax
        ret


_Z12stringConcatPcS_:
        push    r15
        push    r14
        push    r13
        push    r12
        mov     r13, rsi
        push    rbp
        push    rbx
        sub     rsp, 24
        mov     rbx, qword [rdi]
        mov     rbp, qword [rsi]
        mov     qword [rsp+8H], rdi
        lea     r15d, [rbp+rbx]
        lea     edi, [r15+9H]
        movsxd  r15, r15d
        movsxd  rdi, edi
        call    malloc
        test    ebx, ebx
        mov     r12, rax
        mov     qword [rax], r15
        mov     rcx, qword [rsp+8H]
        jle     L_006
        lea     edx, [rbx-1H]
        lea     rdi, [rax+8H]
        lea     rsi, [rcx+8H]
        mov     r14d, ebx
        movsxd  rbx, ebx
        add     rdx, 1
        call    memcpy
L_004:  test    ebp, ebp
        jle     L_005
        movsxd  rax, r14d
        lea     edx, [rbp-1H]
        lea     ebx, [r14+rbp]
        lea     rdi, [r12+rax+8H]
        lea     rsi, [r13+8H]
        add     rdx, 1
        movsxd  rbx, ebx
        call    memcpy
L_005:  mov     byte [r12+rbx+8H], 0
        add     rsp, 24
        mov     rax, r12
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret





ALIGN   8
L_006:  xor     ebx, ebx
        xor     r14d, r14d
        jmp     L_004


        nop

ALIGN   16
_Z9stringEquPcS_:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        test    eax, eax
        sete    al
        add     rsp, 8
        movzx   eax, al
        ret






ALIGN   8

_Z10stringLessPcS_:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        add     rsp, 8
        shr     eax, 31
        ret






ALIGN   8

_Z9stringLeqPcS_:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        test    eax, eax
        setle   al
        add     rsp, 8
        movzx   eax, al
        ret






ALIGN   8

_Z9stringOrdPci:
        movsxd  rsi, esi
        movsx   eax, byte [rdi+rsi+8H]
        ret






ALIGN   8

_Z5printPc:
        lea     rdx, [rdi+8H]
        mov     esi, L_061
        mov     edi, 1
        xor     eax, eax
        jmp     __printf_chk


        nop





ALIGN   16

_Z7printlnPc:
        add     rdi, 8
        jmp     puts






ALIGN   8

_Z8printInti:
        push    rbx
        sub     rsp, 48


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+28H], rax
        xor     eax, eax
        test    edi, edi
        je      L_010
        mov     ebx, edi
        js      L_011
L_007:  mov     eax, ebx
        mov     esi, 1717986919
        mov     ecx, ebx
        imul    esi
        sar     ecx, 31
        sar     edx, 2
        sub     edx, ecx
        lea     eax, [rdx+rdx*4]
        mov     edi, edx
        mov     edx, ebx
        add     eax, eax
        sub     edx, eax
        test    edi, edi
        mov     dword [rsp], edx
        je      L_018
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+4H], edi
        mov     edi, 1374389535
        imul    edi
        sar     edx, 5
        mov     edi, edx
        sub     edi, ecx
        je      L_016
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+8H], edi
        mov     edi, 274877907
        imul    edi
        sar     edx, 6
        mov     edi, edx
        sub     edi, ecx
        je      L_017
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+0CH], edi
        mov     edi, 1759218605
        imul    edi
        sar     edx, 12
        mov     edi, edx
        sub     edi, ecx
        je      L_012
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+10H], edi
        mov     edi, 351843721
        imul    edi
        sar     edx, 13
        mov     edi, edx
        sub     edi, ecx
        je      L_013
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+14H], edi
        mov     edi, 1125899907
        imul    edi
        sar     edx, 18
        mov     edi, edx
        sub     edi, ecx
        je      L_014
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+18H], edi
        mov     edi, 1801439851
        imul    edi
        sar     edx, 22
        mov     edi, edx
        sub     edi, ecx
        je      L_015
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+1CH], edi
        mov     edi, 1441151881
        imul    edi
        sar     edx, 25
        mov     edi, edx
        sub     edi, ecx
        je      L_019
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        imul    edx
        mov     dword [rsp+20H], edi
        sar     edx, 28
        sub     edx, ecx
        je      L_020
        mov     dword [rsp+24H], edx
        mov     ebx, 10
L_008:  sub     ebx, 1




ALIGN   8
L_009:  movsxd  rax, ebx
        mov     rsi, qword [rel stdout]
        sub     ebx, 1
        mov     edi, dword [rsp+rax*4]
        add     edi, 48
        call    _IO_putc
        cmp     ebx, -1
        jnz     L_009
        mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_021
        add     rsp, 48
        pop     rbx
        ret





ALIGN   8
L_010:  mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_021
        mov     rsi, qword [rel stdout]
        add     rsp, 48
        mov     edi, 48
        pop     rbx
        jmp     _IO_putc





ALIGN   8
L_011:  mov     rsi, qword [rel stdout]
        mov     edi, 45
        neg     ebx
        call    _IO_putc
        jmp     L_007

L_012:  mov     ebx, 4
        jmp     L_008

L_013:  mov     ebx, 5
        jmp     L_008

L_014:  mov     ebx, 6
        jmp     L_008

L_015:  mov     ebx, 7
        jmp     L_008

L_016:  mov     ebx, 2
        jmp     L_008

L_017:  mov     ebx, 3
        jmp     L_008

L_018:  mov     ebx, 1
        jmp     L_008

L_019:  mov     ebx, 8
        jmp     L_008

L_020:  mov     ebx, 9
        jmp     L_008

L_021:  call    __stack_chk_fail





ALIGN   16

_Z10printlnInti:
        push    rbx
        sub     rsp, 48


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+28H], rax
        xor     eax, eax
        test    edi, edi
        je      L_026
        mov     ebx, edi
        js      L_027
L_022:  mov     eax, ebx
        mov     esi, 1717986919
        mov     ecx, ebx
        imul    esi
        sar     ecx, 31
        sar     edx, 2
        sub     edx, ecx
        lea     eax, [rdx+rdx*4]
        mov     edi, edx
        mov     edx, ebx
        add     eax, eax
        sub     edx, eax
        test    edi, edi
        mov     dword [rsp], edx
        je      L_034
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+4H], edi
        mov     edi, 1374389535
        imul    edi
        sar     edx, 5
        mov     edi, edx
        sub     edi, ecx
        je      L_032
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+8H], edi
        mov     edi, 274877907
        imul    edi
        sar     edx, 6
        mov     edi, edx
        sub     edi, ecx
        je      L_033
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+0CH], edi
        mov     edi, 1759218605
        imul    edi
        sar     edx, 12
        mov     edi, edx
        sub     edi, ecx
        je      L_028
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+10H], edi
        mov     edi, 351843721
        imul    edi
        sar     edx, 13
        mov     edi, edx
        sub     edi, ecx
        je      L_029
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+14H], edi
        mov     edi, 1125899907
        imul    edi
        sar     edx, 18
        mov     edi, edx
        sub     edi, ecx
        je      L_030
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+18H], edi
        mov     edi, 1801439851
        imul    edi
        sar     edx, 22
        mov     edi, edx
        sub     edi, ecx
        je      L_031
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        mov     dword [rsp+1CH], edi
        mov     edi, 1441151881
        imul    edi
        sar     edx, 25
        mov     edi, edx
        sub     edi, ecx
        je      L_035
        mov     eax, edi
        imul    esi
        mov     eax, edi
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     edi, eax
        mov     eax, ebx
        imul    edx
        mov     dword [rsp+20H], edi
        sar     edx, 28
        sub     edx, ecx
        je      L_036
        mov     dword [rsp+24H], edx
        mov     ebx, 10
L_023:  sub     ebx, 1




ALIGN   8
L_024:  movsxd  rax, ebx
        mov     rsi, qword [rel stdout]
        sub     ebx, 1
        mov     edi, dword [rsp+rax*4]
        add     edi, 48
        call    _IO_putc
        cmp     ebx, -1
        jnz     L_024
L_025:  mov     rax, qword [rsp+28H]


        xor     rax, qword [fs:abs 28H]
        jne     L_037
        mov     rsi, qword [rel stdout]
        add     rsp, 48
        mov     edi, 10
        pop     rbx
        jmp     _IO_putc





ALIGN   8
L_026:  mov     rsi, qword [rel stdout]
        mov     edi, 48
        call    _IO_putc
        jmp     L_025





ALIGN   8
L_027:  mov     rsi, qword [rel stdout]
        mov     edi, 45
        neg     ebx
        call    _IO_putc
        jmp     L_022

L_028:  mov     ebx, 4
        jmp     L_023

L_029:  mov     ebx, 5
        jmp     L_023

L_030:  mov     ebx, 6
        jmp     L_023

L_031:  mov     ebx, 7
        jmp     L_023

L_032:  mov     ebx, 2
        jmp     L_023

L_033:  mov     ebx, 3
        jmp     L_023

L_034:  mov     ebx, 1
        jmp     L_023

L_035:  mov     ebx, 8
        jmp     L_023

L_036:  mov     ebx, 9
        jmp     L_023

L_037:  call    __stack_chk_fail
        nop
ALIGN   16

_Z9getStringv:
        push    rbp
        push    rbx
        mov     edi, 300
        sub     rsp, 8
        call    malloc
        lea     rbx, [rax+8H]
        mov     rbp, rax
        mov     edi, L_061
        xor     eax, eax
        mov     rsi, rbx
        call    scanf
        mov     rdx, rbx
L_038:  mov     ecx, dword [rdx]
        add     rdx, 4
        lea     eax, [rcx-1010101H]
        not     ecx
        and     eax, ecx
        and     eax, 80808080H
        jz      L_038
        mov     ecx, eax
        shr     ecx, 16
        test    eax, 8080H
        cmove   eax, ecx
        lea     rcx, [rdx+2H]
        mov     esi, eax
        cmove   rdx, rcx
        add     sil, al
        mov     rax, rbp
        sbb     rdx, 3
        sub     rdx, rbx
        mov     qword [rbp], rdx
        add     rsp, 8
        pop     rbx
        pop     rbp
        ret


        nop

ALIGN   16
_Z6getIntv:
        push    rbp
        push    rbx
        sub     rsp, 8
        jmp     L_040





ALIGN   16
L_039:  cmp     al, 45
        jz      L_041
L_040:  mov     rdi, qword [rel stdin]
        call    _IO_getc
        lea     ecx, [rax-30H]
        movsx   edx, al
        cmp     cl, 9
        ja      L_039
L_041:  cmp     dl, 45
        mov     ebp, 1
        jz      L_044
L_042:  xor     ebx, ebx





ALIGN   16
L_043:  mov     rdi, qword [rel stdin]
        lea     eax, [rbx+rbx*4]
        lea     ebx, [rdx+rax*2-30H]
        call    _IO_getc
        movsx   edx, al
        sub     eax, 48
        cmp     al, 9
        jbe     L_043
        mov     eax, ebx
        add     rsp, 8
        imul    eax, ebp
        pop     rbx
        pop     rbp
        ret





ALIGN   8
L_044:  mov     rdi, qword [rel stdin]
        mov     ebp, 4294967295
        call    _IO_getc
        movsx   edx, al
        jmp     L_042







ALIGN   16

_Z8toStringi:
        push    r12
        push    rbp
        push    rbx
        sub     rsp, 64


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+38H], rax
        xor     eax, eax
        test    edi, edi
        js      L_047
        jne     L_050
        mov     edi, 10
        mov     dword [rsp+4H], 0
        xor     ebp, ebp
        call    malloc
        lea     rdx, [rax+8H]
        mov     qword [rax], 1
        mov     byte [rax+9H], 0
        mov     ebx, 1
L_045:  movsxd  rcx, ebx
        movsxd  rsi, ebp
        mov     ecx, dword [rsp+rcx*4]
        add     ecx, 48
        cmp     ebx, 1
        mov     byte [rdx+rsi], cl
        je      L_046
        lea     esi, [rbx-1H]
        lea     ecx, [rbp+1H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 2
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-2H]
        lea     ecx, [rbp+2H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 3
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-3H]
        lea     ecx, [rbp+3H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 4
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-4H]
        lea     ecx, [rbp+4H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 5
        mov     byte [rdx+rcx], sil
        je      L_046
        lea     esi, [rbx-5H]
        lea     ecx, [rbp+5H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 6
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-6H]
        lea     ecx, [rbp+6H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 7
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-7H]
        lea     ecx, [rbp+7H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 8
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-8H]
        lea     ecx, [rbp+8H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 9
        mov     byte [rdx+rcx], sil
        jz      L_046
        lea     esi, [rbx-9H]
        lea     ecx, [rbp+9H]
        movsxd  rsi, esi
        movsxd  rcx, ecx
        mov     esi, dword [rsp+rsi*4]
        add     esi, 48
        cmp     ebx, 10
        mov     byte [rdx+rcx], sil
        jz      L_046
        movzx   edi, byte [rsp+4H]
        add     ebp, 10
        movsxd  rbp, ebp
        lea     ecx, [rdi+30H]
        mov     byte [rdx+rbp], cl
L_046:  mov     rdi, qword [rsp+38H]


        xor     rdi, qword [fs:abs 28H]
        jne     L_060
        add     rsp, 64
        pop     rbx
        pop     rbp
        pop     r12
        ret






ALIGN   16
L_047:  neg     edi
        mov     ebp, 1
L_048:  mov     eax, edi
        mov     esi, 1717986919
        mov     ecx, edi
        imul    esi
        sar     ecx, 31
        mov     ebx, edi
        sar     edx, 2
        sub     edx, ecx
        lea     eax, [rdx+rdx*4]
        mov     r8d, edx
        add     eax, eax
        sub     ebx, eax
        test    edx, edx
        mov     dword [rsp+4H], ebx
        je      L_051
        mov     eax, edx
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+8H], r8d
        mov     r8d, 1374389535
        imul    r8d
        sar     edx, 5
        mov     r8d, edx
        sub     r8d, ecx
        je      L_052
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+0CH], r8d
        mov     r8d, 274877907
        imul    r8d
        sar     edx, 6
        mov     r8d, edx
        sub     r8d, ecx
        je      L_053
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+10H], r8d
        mov     r8d, 1759218605
        imul    r8d
        sar     edx, 12
        mov     r8d, edx
        sub     r8d, ecx
        je      L_054
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+14H], r8d
        mov     r8d, 351843721
        imul    r8d
        sar     edx, 13
        mov     r8d, edx
        sub     r8d, ecx
        je      L_055
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+18H], r8d
        mov     r8d, 1125899907
        imul    r8d
        sar     edx, 18
        mov     r8d, edx
        sub     r8d, ecx
        je      L_056
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+1CH], r8d
        mov     r8d, 1801439851
        imul    r8d
        sar     edx, 22
        mov     r8d, edx
        sub     r8d, ecx
        je      L_057
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        sub     edx, eax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        mov     dword [rsp+20H], r8d
        mov     r8d, 1441151881
        imul    r8d
        sar     edx, 25
        mov     r8d, edx
        sub     r8d, ecx
        je      L_058
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        sar     edx, 2
        mov     esi, edx
        mov     edx, 1152921505
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        imul    edx
        mov     dword [rsp+24H], r8d
        sar     edx, 28
        sub     edx, ecx
        je      L_059
        mov     dword [rsp+28H], edx
        mov     ebx, 10
L_049:  lea     r12d, [rbp+rbx]
        lea     edi, [r12+9H]
        movsxd  r12, r12d
        movsxd  rdi, edi
        call    malloc
        test    ebp, ebp
        mov     qword [rax], r12
        lea     rdx, [rax+8H]
        mov     byte [rax+r12+8H], 0
        je      L_045
        mov     byte [rax+8H], 45
        mov     ebp, 1
        jmp     L_045






ALIGN   16
L_050:  xor     ebp, ebp
        jmp     L_048






ALIGN   16
L_051:  mov     ebx, 1
        jmp     L_049






ALIGN   16
L_052:  mov     ebx, 2
        jmp     L_049






ALIGN   16
L_053:  mov     ebx, 3
        jmp     L_049






ALIGN   16
L_054:  mov     ebx, 4
        jmp     L_049





ALIGN   8
L_055:  mov     ebx, 5
        jmp     L_049





ALIGN   8
L_056:  mov     ebx, 6
        jmp     L_049





ALIGN   8
L_057:  mov     ebx, 7
        jmp     L_049





ALIGN   8
L_058:  mov     ebx, 8
        jmp     L_049





ALIGN   8
L_059:  mov     ebx, 9
        jmp     L_049

L_060:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 


SECTION .rodata.str1.1 

L_061:
        db 25H, 73H, 00H


