global main

extern malloc
section .text

main:
main..main.entry:
	push rbp
	mov rbp,rsp
	sub rsp,112
	mov r14,qword [___total]
	mov rsi,qword [___j]
	mov rdi,qword [___h]
	mov r9,qword [___i]
	mov rcx,qword [___N]
	mov rdx,qword [___k]
	mov qword [___total],r14
	mov qword [___N],rcx
	mov qword [rsp+24],r8
	mov qword [rsp+32],rsi
	mov qword [rsp+40],r13
	mov qword [rsp+48],rdx
	mov qword [rsp+56],rcx
	mov qword [rsp+64],r12
	mov qword [rsp+72],rdi
	mov qword [rsp+80],r15
	mov qword [rsp+88],r14
	mov qword [rsp+96],r9
	call ____init
	mov r9,qword [rsp+96]
	mov r14,qword [rsp+88]
	mov r15,qword [rsp+80]
	mov rdi,qword [rsp+72]
	mov r12,qword [rsp+64]
	mov rcx,qword [rsp+56]
	mov rdx,qword [rsp+48]
	mov r13,qword [rsp+40]
	mov rsi,qword [rsp+32]
	mov r8,qword [rsp+24]
	mov rdx,qword [___k]
	mov rcx,qword [___N]
	mov r9,qword [___i]
	mov rdi,qword [___h]
	mov rsi,qword [___j]
	mov r14,qword [___total]
	mov r10,0
	mov qword [rsp],r10
	mov r12,0
	mov r15,0
	mov r10,0
	mov qword [rsp+16],r10
	mov r13,0
	mov r10,0
	mov qword [rsp+8],r10
	mov qword [rsp+24],r8
	mov qword [rsp+32],rsi
	mov qword [rsp+48],rdx
	mov qword [rsp+56],rcx
	mov qword [rsp+72],rdi
	mov qword [rsp+96],r9
	call _Z6getIntv
	mov r9,qword [rsp+96]
	mov rdi,qword [rsp+72]
	mov rcx,qword [rsp+56]
	mov rdx,qword [rsp+48]
	mov rsi,qword [rsp+32]
	mov r8,qword [rsp+24]
	mov rcx,rax
	mov r10,1
	mov qword [rsp],r10
	jmp main..for_cond
main..for_cond:
	mov r10,qword [rsp]
	cmp r10,rcx
	mov r8,0
	setle r8b
	cmp r8b,1
	jz main..for_loop
	jnz main..for_after
main..for_after:
	mov qword [rsp+24],r8
	mov qword [rsp+32],rsi
	mov qword [rsp+48],rdx
	mov qword [rsp+56],rcx
	mov qword [rsp+72],rdi
	mov qword [rsp+96],r9
	mov rdi,r14
	call _Z10printlnInti
	mov r9,qword [rsp+96]
	mov rdi,qword [rsp+72]
	mov rcx,qword [rsp+56]
	mov rdx,qword [rsp+48]
	mov rsi,qword [rsp+32]
	mov r8,qword [rsp+24]
	mov qword [___total],r14
	mov qword [___N],rcx
	mov rax,0
	leave
	ret
main..for_loop:
	mov r12,1
	jmp main..for_cond_2
main..for_cond_2:
	cmp r12,rcx
	mov r8,0
	setle r8b
	cmp r8b,1
	jz main..for_loop_2
	jnz main..for_after_2
main..for_after_2:
	jmp main..for_step
main..for_step:
	mov r10,qword [rsp]
	mov r8,r10
	mov r11,qword [rsp]
	add r11,1
	mov qword [rsp],r11
	jmp main..for_cond
main..for_loop_2:
	mov r15,1
	jmp main..for_cond_3
main..for_cond_3:
	cmp r15,rcx
	mov r8,0
	setle r8b
	cmp r8b,1
	jz main..for_loop_3
	jnz main..for_after_3
main..for_after_3:
	jmp main..for_step_2
main..for_step_2:
	mov r8,r12
	add r12,1
	jmp main..for_cond_2
main..for_loop_3:
	mov r10,1
	mov qword [rsp+16],r10
	jmp main..for_cond_4
main..for_cond_4:
	mov r10,qword [rsp+16]
	cmp r10,rcx
	mov r8,0
	setle r8b
	cmp r8b,1
	jz main..for_loop_4
	jnz main..for_after_4
main..for_after_4:
	jmp main..for_step_3
main..for_step_3:
	mov r8,r15
	add r15,1
	jmp main..for_cond_3
main..for_loop_4:
	mov r13,1
	jmp main..for_cond_5
main..for_cond_5:
	cmp r13,rcx
	mov r8,0
	setle r8b
	cmp r8b,1
	jz main..for_loop_5
	jnz main..for_after_5
main..for_after_5:
	jmp main..for_step_4
main..for_step_4:
	mov r10,qword [rsp+16]
	mov r8,r10
	mov r11,qword [rsp+16]
	add r11,1
	mov qword [rsp+16],r11
	jmp main..for_cond_4
main..for_loop_5:
	mov r10,1
	mov qword [rsp+8],r10
	jmp main..for_cond_6
main..for_cond_6:
	mov r10,qword [rsp+8]
	cmp r10,rcx
	mov r8,0
	setle r8b
	cmp r8b,1
	jz main..for_loop_6
	jnz main..for_after_6
main..for_loop_6:
	mov r10,qword [rsp]
	cmp r10,r12
	mov r8,0
	setne r8b
	cmp r8b,1
	jz main..lhs_true
	jnz main..lhs_false
main..lhs_true:
	mov r10,qword [rsp]
	cmp r10,r15
	mov r8,0
	setne r8b
	jmp main..lhs_merge
main..lhs_false:
	mov r8,0
	jmp main..lhs_merge
main..lhs_merge:
	cmp r8b,1
	jz main..lhs_true_2
	jnz main..lhs_false_2
main..lhs_true_2:
	mov r10,qword [rsp]
	mov r11,qword [rsp+16]
	cmp r10,r11
	mov r8,0
	setne r8b
	jmp main..lhs_merge_2
main..lhs_false_2:
	mov r8,0
	jmp main..lhs_merge_2
main..lhs_merge_2:
	cmp r8b,1
	jz main..lhs_true_3
	jnz main..lhs_false_3
main..lhs_false_3:
	mov r8,0
	jmp main..lhs_merge_3
main..lhs_true_3:
	mov r10,qword [rsp]
	cmp r10,r13
	mov r8,0
	setne r8b
	jmp main..lhs_merge_3
main..lhs_merge_3:
	cmp r8b,1
	jz main..lhs_true_4
	jnz main..lhs_false_4
main..lhs_true_4:
	mov r10,qword [rsp]
	mov r11,qword [rsp+8]
	cmp r10,r11
	mov r8,0
	setne r8b
	jmp main..lhs_merge_4
main..lhs_false_4:
	mov r8,0
	jmp main..lhs_merge_4
main..lhs_merge_4:
	cmp r8b,1
	jz main..lhs_true_5
	jnz main..lhs_false_5
main..lhs_true_5:
	mov r10,qword [rsp]
	cmp r10,rdi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_5
main..lhs_false_5:
	mov r8,0
	jmp main..lhs_merge_5
main..lhs_merge_5:
	cmp r8b,1
	jz main..lhs_true_6
	jnz main..lhs_false_6
main..lhs_false_6:
	mov r8,0
	jmp main..lhs_merge_6
main..lhs_true_6:
	mov r10,qword [rsp]
	cmp r10,r9
	mov r8,0
	setne r8b
	jmp main..lhs_merge_6
main..lhs_merge_6:
	cmp r8b,1
	jz main..lhs_true_7
	jnz main..lhs_false_7
main..lhs_true_7:
	mov r10,qword [rsp]
	cmp r10,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_7
main..lhs_false_7:
	mov r8,0
	jmp main..lhs_merge_7
main..lhs_merge_7:
	cmp r8b,1
	jz main..lhs_true_8
	jnz main..lhs_false_8
main..lhs_true_8:
	mov r10,qword [rsp]
	cmp r10,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_8
main..lhs_false_8:
	mov r8,0
	jmp main..lhs_merge_8
main..lhs_merge_8:
	cmp r8b,1
	jz main..lhs_true_9
	jnz main..lhs_false_9
main..lhs_true_9:
	cmp r12,r15
	mov r8,0
	setne r8b
	jmp main..lhs_merge_9
main..lhs_false_9:
	mov r8,0
	jmp main..lhs_merge_9
main..lhs_merge_9:
	cmp r8b,1
	jz main..lhs_true_10
	jnz main..lhs_false_10
main..lhs_false_10:
	mov r8,0
	jmp main..lhs_merge_10
main..lhs_true_10:
	mov r10,qword [rsp+16]
	cmp r12,r10
	mov r8,0
	setne r8b
	jmp main..lhs_merge_10
main..lhs_merge_10:
	cmp r8b,1
	jz main..lhs_true_11
	jnz main..lhs_false_11
main..lhs_true_11:
	cmp r12,r13
	mov r8,0
	setne r8b
	jmp main..lhs_merge_11
main..lhs_false_11:
	mov r8,0
	jmp main..lhs_merge_11
main..lhs_merge_11:
	cmp r8b,1
	jz main..lhs_true_12
	jnz main..lhs_false_12
main..lhs_false_12:
	mov r8,0
	jmp main..lhs_merge_12
main..lhs_true_12:
	mov r10,qword [rsp+8]
	cmp r12,r10
	mov r8,0
	setne r8b
	jmp main..lhs_merge_12
main..lhs_merge_12:
	cmp r8b,1
	jz main..lhs_true_13
	jnz main..lhs_false_13
main..lhs_true_13:
	cmp r12,rdi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_13
main..lhs_false_13:
	mov r8,0
	jmp main..lhs_merge_13
main..lhs_merge_13:
	cmp r8b,1
	jz main..lhs_true_14
	jnz main..lhs_false_14
main..lhs_false_14:
	mov r8,0
	jmp main..lhs_merge_14
main..lhs_true_14:
	cmp r12,r9
	mov r8,0
	setne r8b
	jmp main..lhs_merge_14
main..lhs_merge_14:
	cmp r8b,1
	jz main..lhs_true_15
	jnz main..lhs_false_15
main..lhs_false_15:
	mov r8,0
	jmp main..lhs_merge_15
main..lhs_true_15:
	cmp r12,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_15
main..lhs_merge_15:
	cmp r8b,1
	jz main..lhs_true_16
	jnz main..lhs_false_16
main..lhs_false_16:
	mov r8,0
	jmp main..lhs_merge_16
main..lhs_true_16:
	cmp r12,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_16
main..lhs_merge_16:
	cmp r8b,1
	jz main..lhs_true_17
	jnz main..lhs_false_17
main..lhs_true_17:
	mov r10,qword [rsp+16]
	cmp r15,r10
	mov r8,0
	setne r8b
	jmp main..lhs_merge_17
main..lhs_false_17:
	mov r8,0
	jmp main..lhs_merge_17
main..lhs_merge_17:
	cmp r8b,1
	jz main..lhs_true_18
	jnz main..lhs_false_18
main..lhs_false_18:
	mov r8,0
	jmp main..lhs_merge_18
main..lhs_true_18:
	cmp r15,r13
	mov r8,0
	setne r8b
	jmp main..lhs_merge_18
main..lhs_merge_18:
	cmp r8b,1
	jz main..lhs_true_19
	jnz main..lhs_false_19
main..lhs_false_19:
	mov r8,0
	jmp main..lhs_merge_19
main..lhs_true_19:
	mov r10,qword [rsp+8]
	cmp r15,r10
	mov r8,0
	setne r8b
	jmp main..lhs_merge_19
main..lhs_merge_19:
	cmp r8b,1
	jz main..lhs_true_20
	jnz main..lhs_false_20
main..lhs_false_20:
	mov r8,0
	jmp main..lhs_merge_20
main..lhs_true_20:
	cmp r15,rdi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_20
main..lhs_merge_20:
	cmp r8b,1
	jz main..lhs_true_21
	jnz main..lhs_false_21
main..lhs_false_21:
	mov r8,0
	jmp main..lhs_merge_21
main..lhs_true_21:
	cmp r15,r9
	mov r8,0
	setne r8b
	jmp main..lhs_merge_21
main..lhs_merge_21:
	cmp r8b,1
	jz main..lhs_true_22
	jnz main..lhs_false_22
main..lhs_true_22:
	cmp r15,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_22
main..lhs_false_22:
	mov r8,0
	jmp main..lhs_merge_22
main..lhs_merge_22:
	cmp r8b,1
	jz main..lhs_true_23
	jnz main..lhs_false_23
main..lhs_false_23:
	mov r8,0
	jmp main..lhs_merge_23
main..lhs_true_23:
	cmp r15,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_23
main..lhs_merge_23:
	cmp r8b,1
	jz main..lhs_true_24
	jnz main..lhs_false_24
main..lhs_true_24:
	mov r10,qword [rsp+16]
	cmp r10,r13
	mov r8,0
	setne r8b
	jmp main..lhs_merge_24
main..lhs_false_24:
	mov r8,0
	jmp main..lhs_merge_24
main..lhs_merge_24:
	cmp r8b,1
	jz main..lhs_true_25
	jnz main..lhs_false_25
main..lhs_true_25:
	mov r10,qword [rsp+16]
	mov r11,qword [rsp+8]
	cmp r10,r11
	mov r8,0
	setne r8b
	jmp main..lhs_merge_25
main..lhs_false_25:
	mov r8,0
	jmp main..lhs_merge_25
main..lhs_merge_25:
	cmp r8b,1
	jz main..lhs_true_26
	jnz main..lhs_false_26
main..lhs_false_26:
	mov r8,0
	jmp main..lhs_merge_26
main..lhs_true_26:
	mov r10,qword [rsp+16]
	cmp r10,rdi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_26
main..lhs_merge_26:
	cmp r8b,1
	jz main..lhs_true_27
	jnz main..lhs_false_27
main..lhs_false_27:
	mov r8,0
	jmp main..lhs_merge_27
main..lhs_true_27:
	mov r10,qword [rsp+16]
	cmp r10,r9
	mov r8,0
	setne r8b
	jmp main..lhs_merge_27
main..lhs_merge_27:
	cmp r8b,1
	jz main..lhs_true_28
	jnz main..lhs_false_28
main..lhs_false_28:
	mov r8,0
	jmp main..lhs_merge_28
main..lhs_true_28:
	mov r10,qword [rsp+16]
	cmp r10,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_28
main..lhs_merge_28:
	cmp r8b,1
	jz main..lhs_true_29
	jnz main..lhs_false_29
main..lhs_false_29:
	mov r8,0
	jmp main..lhs_merge_29
main..lhs_true_29:
	mov r10,qword [rsp+16]
	cmp r10,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_29
main..lhs_merge_29:
	cmp r8b,1
	jz main..lhs_true_30
	jnz main..lhs_false_30
main..lhs_true_30:
	mov r10,qword [rsp+8]
	cmp r13,r10
	mov r8,0
	setne r8b
	jmp main..lhs_merge_30
main..lhs_false_30:
	mov r8,0
	jmp main..lhs_merge_30
main..lhs_merge_30:
	cmp r8b,1
	jz main..lhs_true_31
	jnz main..lhs_false_31
main..lhs_true_31:
	cmp r13,rdi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_31
main..lhs_false_31:
	mov r8,0
	jmp main..lhs_merge_31
main..lhs_merge_31:
	cmp r8b,1
	jz main..lhs_true_32
	jnz main..lhs_false_32
main..lhs_true_32:
	cmp r13,r9
	mov r8,0
	setne r8b
	jmp main..lhs_merge_32
main..lhs_false_32:
	mov r8,0
	jmp main..lhs_merge_32
main..lhs_merge_32:
	cmp r8b,1
	jz main..lhs_true_33
	jnz main..lhs_false_33
main..lhs_false_33:
	mov r8,0
	jmp main..lhs_merge_33
main..lhs_true_33:
	cmp r13,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_33
main..lhs_merge_33:
	cmp r8b,1
	jz main..lhs_true_34
	jnz main..lhs_false_34
main..lhs_true_34:
	cmp r13,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_34
main..lhs_false_34:
	mov r8,0
	jmp main..lhs_merge_34
main..lhs_merge_34:
	cmp r8b,1
	jz main..lhs_true_35
	jnz main..lhs_false_35
main..lhs_true_35:
	mov r10,qword [rsp+8]
	cmp r10,rdi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_35
main..lhs_false_35:
	mov r8,0
	jmp main..lhs_merge_35
main..lhs_merge_35:
	cmp r8b,1
	jz main..lhs_true_36
	jnz main..lhs_false_36
main..lhs_true_36:
	mov r10,qword [rsp+8]
	cmp r10,r9
	mov r8,0
	setne r8b
	jmp main..lhs_merge_36
main..lhs_false_36:
	mov r8,0
	jmp main..lhs_merge_36
main..lhs_merge_36:
	cmp r8b,1
	jz main..lhs_true_37
	jnz main..lhs_false_37
main..lhs_false_37:
	mov r8,0
	jmp main..lhs_merge_37
main..lhs_true_37:
	mov r10,qword [rsp+8]
	cmp r10,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_37
main..lhs_merge_37:
	cmp r8b,1
	jz main..lhs_true_38
	jnz main..lhs_false_38
main..lhs_true_38:
	mov r10,qword [rsp+8]
	cmp r10,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_38
main..lhs_false_38:
	mov r8,0
	jmp main..lhs_merge_38
main..lhs_merge_38:
	cmp r8b,1
	jz main..lhs_true_39
	jnz main..lhs_false_39
main..lhs_false_39:
	mov r8,0
	jmp main..lhs_merge_39
main..lhs_true_39:
	cmp r9,rsi
	mov r8,0
	setne r8b
	jmp main..lhs_merge_39
main..lhs_merge_39:
	cmp r8b,1
	jz main..lhs_true_40
	jnz main..lhs_false_40
main..lhs_false_40:
	mov r8,0
	jmp main..lhs_merge_40
main..lhs_true_40:
	cmp rdi,rdx
	mov r8,0
	setne r8b
	jmp main..lhs_merge_40
main..lhs_merge_40:
	cmp r8b,1
	jz main..if_true
	jnz main..if_after
main..if_true:
	mov r8,r14
	add r14,1
	jmp main..if_after
main..if_after:
	jmp main..for_step_5
main..for_step_5:
	mov r10,qword [rsp+8]
	mov r8,r10
	mov r11,qword [rsp+8]
	add r11,1
	mov qword [rsp+8],r11
	jmp main..for_cond_6
main..for_after_6:
	jmp main..for_step_6
main..for_step_6:
	mov r8,r13
	add r13,1
	jmp main..for_cond_5

____init:
____init.._init.entry:
	push rbp
	mov rbp,rsp
	sub rsp,48
	mov r8,qword [___total]
	mov r12,qword [___j]
	mov rsi,qword [___h]
	mov r13,qword [___i]
	mov rdx,qword [___N]
	mov rcx,qword [___k]
	mov rdx,0
	mov rsi,99
	mov r13,100
	mov r12,101
	mov rcx,102
	mov r8,0
	mov qword [___total],r8
	mov qword [___j],r12
	mov qword [___h],rsi
	mov qword [___i],r13
	mov qword [___N],rdx
	mov qword [___k],rcx
	leave
	ret

	section .data

section .bss
___N:
	resb 64
___h:
	resb 64
___i:
	resb 64
___j:
	resb 64
___k:
	resb 64
___total:
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


