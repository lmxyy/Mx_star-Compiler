	global main

	extern malloc

	section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,368
	call __init
	mov r8,5
	mov qword [rbp-272],r8
	mov r8,10
	mov qword [rbp-120],r8
	mov r8,0
	mov qword [rbp-48],r8
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-160],r9
	mov r8,qword [rbp-120]
	imul r8,8
	mov qword [rbp-120],r8
	mov r8,qword [rbp-120]
	mov r9,r8
	mov qword [rbp-104],r9
	mov r8,qword [rbp-160]
	mov r9,r8
	mov qword [rbp-120],r9
	mov r8,qword [rbp-104]
	add r8,8
	mov qword [rbp-104],r8
	mov r8,qword [rbp-104]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-104],r8
	mov r8,qword [rbp-104]
	mov r9,qword [rbp-120]
	mov qword [r8],r9
	mov r8,qword [rbp-104]
	mov r9,r8
	mov qword [rbp-80],r9
	mov r8,24
	mov qword [rbp-176],r8
	mov r8,qword [rbp-176]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-176],r8
	mov r8,qword [rbp-176]
	mov qword [r8],2
	mov r8,qword [rbp-176]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-272]
	mov r9,r8
	mov qword [rbp-56],r9
	mov r8,qword [rbp-272]
	imul r8,8
	mov qword [rbp-272],r8
	mov r8,qword [rbp-272]
	mov r9,r8
	mov qword [rbp-192],r9
	mov r8,qword [rbp-56]
	mov r9,r8
	mov qword [rbp-272],r9
	mov r8,qword [rbp-192]
	add r8,8
	mov qword [rbp-192],r8
	mov r8,qword [rbp-192]
	mov rdi,r8
	call malloc
	mov r8,rax
	mov qword [rbp-192],r8
	mov r8,qword [rbp-192]
	mov r9,qword [rbp-272]
	mov qword [r8],r9
	mov r8,qword [rbp-192]
	mov r9,r8
	mov qword [rbp-48],r9
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-304],r9
	mov r8,qword [rbp-8]
	add r8,0
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-240],r9
	mov r8,qword [rbp-304]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-240]
	mov r9,qword [rbp-48]
	mov qword [r8+8],r9
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-200],r9
	mov r8,qword [rbp-8]
	add r8,8
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-280],r9
	mov r8,qword [rbp-200]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-280]
	mov r9,qword [rbp-80]
	mov qword [r8+8],r9
	mov r8,0
	mov qword [rbp-136],r8
	mov r8,0
	mov qword [rbp-16],r8
	mov r8,0
	mov qword [rbp-256],r8
	mov r8,0
	mov qword [rbp-16],r8
	jmp main..for_cond
main..for_cond:
	mov r8,qword [rbp-16]
	cmp r8,2
	mov r9,0
	setl r9b
	mov qword [rbp-96],r9
	mov r8,qword [rbp-96]
	cmp r8,1
	jz main..for_loop
	jnz main..for_after
main..for_loop:
	mov r8,0
	mov qword [rbp-256],r8
	jmp main..for_cond_2
main..for_cond_2:
	mov r8,qword [rbp-256]
	mov r9,qword [rbp-272]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-168],r10
	mov r8,qword [rbp-168]
	cmp r8,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_after_2:
	jmp main..for_step
main..for_step:
	mov r8,qword [rbp-16]
	add r8,1
	mov qword [rbp-16],r8
	jmp main..for_cond
main..for_loop_2:
	mov r8,qword [rbp-136]
	add r8,1
	mov qword [rbp-136],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-184],r9
	mov r8,qword [rbp-16]
	imul r8,8
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-184]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-8]
	mov r9,qword [rbp-152]
	add r9,r8
	mov qword [rbp-152],r9
	mov r8,qword [rbp-152]
	mov r8,qword [r8+8]
	mov qword [rbp-152],r8
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-208],r9
	mov r8,qword [rbp-256]
	imul r8,8
	mov qword [rbp-256],r8
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-208]
	mov r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-152]
	mov r9,qword [rbp-32]
	add r9,r8
	mov qword [rbp-32],r9
	mov r8,qword [rbp-32]
	mov r9,qword [rbp-136]
	mov qword [r8+8],r9
	jmp main..for_step_2
main..for_step_2:
	mov r8,qword [rbp-256]
	add r8,1
	mov qword [rbp-256],r8
	jmp main..for_cond_2
main..for_after:
	mov r8,qword [rbp-272]
	mov r9,r8
	mov qword [rbp-256],r9
	jmp main..for_cond_3
main..for_cond_3:
	mov r8,qword [rbp-256]
	mov r9,qword [rbp-120]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-248],r10
	mov r8,qword [rbp-248]
	cmp r8,1
	jz main..for_loop_3
	jnz main..for_after_3
main..for_after_3:
	mov r8,0
	mov qword [rbp-288],r8
	mov r8,0
	mov qword [rbp-16],r8
	jmp main..for_cond_4
main..for_cond_4:
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-272]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-88],r10
	mov r8,qword [rbp-88]
	cmp r8,1
	jz main..for_loop_4
	jnz main..for_after_4
main..for_loop_4:
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-224],r9
	mov r8,qword [rbp-16]
	imul r8,8
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-224]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-48]
	mov r9,qword [rbp-128]
	add r9,r8
	mov qword [rbp-128],r9
	mov r8,qword [rbp-128]
	mov r8,qword [r8+8]
	mov qword [rbp-128],r8
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-112],r9
	mov r8,qword [rbp-128]
	mov r9,qword [rbp-288]
	add r9,r8
	mov qword [rbp-288],r9
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-72],r9
	mov r8,qword [rbp-112]
	mov r9,r8
	mov qword [rbp-288],r9
	mov r8,qword [rbp-72]
	mov r9,r8
	mov qword [rbp-288],r9
	jmp main..for_step_3
main..for_step_3:
	mov r8,qword [rbp-16]
	add r8,1
	mov qword [rbp-16],r8
	jmp main..for_cond_4
main..for_after_4:
	mov r8,0
	mov qword [rbp-16],r8
	jmp main..for_cond_5
main..for_cond_5:
	mov r8,qword [rbp-16]
	mov r9,qword [rbp-120]
	cmp r8,r9
	mov r10,0
	setl r10b
	mov qword [rbp-296],r10
	mov r8,qword [rbp-296]
	cmp r8,1
	jz main..for_loop_5
	jnz main..for_after_5
main..for_after_5:
	mov r8,qword [rbp-288]
	mov rax,r8
	leave
	ret
main..for_loop_5:
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-40],r9
	mov r8,qword [rbp-16]
	imul r8,8
	mov qword [rbp-16],r8
	mov r8,qword [rbp-16]
	mov r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-40]
	mov r9,r8
	mov qword [rbp-16],r9
	mov r8,qword [rbp-80]
	mov r9,qword [rbp-144]
	add r9,r8
	mov qword [rbp-144],r9
	mov r8,qword [rbp-144]
	mov r8,qword [r8+8]
	mov qword [rbp-144],r8
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-216],r9
	mov r8,qword [rbp-144]
	mov r9,qword [rbp-288]
	add r9,r8
	mov qword [rbp-288],r9
	mov r8,qword [rbp-288]
	mov r9,r8
	mov qword [rbp-24],r9
	mov r8,qword [rbp-216]
	mov r9,r8
	mov qword [rbp-288],r9
	mov r8,qword [rbp-24]
	mov r9,r8
	mov qword [rbp-288],r9
	jmp main..for_step_4
main..for_step_4:
	mov r8,qword [rbp-16]
	add r8,1
	mov qword [rbp-16],r8
	jmp main..for_cond_5
main..for_loop_3:
	mov r8,qword [rbp-136]
	add r8,1
	mov qword [rbp-136],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-232],r9
	mov r8,qword [rbp-8]
	add r8,8
	mov qword [rbp-8],r8
	mov r8,qword [rbp-8]
	mov r9,r8
	mov qword [rbp-64],r9
	mov r8,qword [rbp-232]
	mov r9,r8
	mov qword [rbp-8],r9
	mov r8,qword [rbp-64]
	mov r8,qword [r8+8]
	mov qword [rbp-64],r8
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-264],r9
	mov r8,qword [rbp-256]
	imul r8,8
	mov qword [rbp-256],r8
	mov r8,qword [rbp-256]
	mov r9,r8
	mov qword [rbp-312],r9
	mov r8,qword [rbp-264]
	mov r9,r8
	mov qword [rbp-256],r9
	mov r8,qword [rbp-64]
	mov r9,qword [rbp-312]
	add r9,r8
	mov qword [rbp-312],r9
	mov r8,qword [rbp-312]
	mov r9,qword [rbp-136]
	mov qword [r8+8],r9
	jmp main..for_step_5
main..for_step_5:
	mov r8,qword [rbp-256]
	add r8,1
	mov qword [rbp-256],r8
	jmp main..for_cond_3

__init:
__init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	leave
	ret

	section .data

	section .bss
