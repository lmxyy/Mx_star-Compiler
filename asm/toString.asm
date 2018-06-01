





default rel

global toString

extern __stack_chk_fail
extern malloc


SECTION .text 

toString:
        push    rbp
        push    rbx
        sub     rsp, 72


        mov     rax, qword [fs:abs 28H]
        mov     qword [rsp+38H], rax
        xor     eax, eax
        test    edi, edi
        js      L_002
        jne     L_005
        mov     edi, 9
        call    malloc
        movzx   ebx, byte [rsp]
        mov     qword [rax], 1
        mov     byte [rax+9H], 0
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
L_001:  mov     rbx, qword [rsp+38H]


        xor     rbx, qword [fs:abs 28H]
        jne     L_015
        add     rsp, 72
        pop     rbx
        pop     rbp
        ret





ALIGN   8
L_002:  neg     edi
        mov     r9d, 1
L_003:  mov     eax, edi
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
        je      L_006
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
        je      L_007
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
        je      L_008
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
        je      L_009
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
        je      L_010
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
        je      L_011
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
        je      L_012
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
        je      L_013
        mov     eax, r8d
        imul    esi
        mov     eax, r8d
        sar     eax, 31
        mov     esi, edx
        mov     edx, 1152921505
        sar     esi, 2
        sub     esi, eax
        lea     eax, [rsi+rsi*4]
        add     eax, eax
        sub     r8d, eax
        mov     eax, edi
        imul    edx
        mov     dword [rsp+24H], r8d
        sar     edx, 28
        sub     edx, ecx
        je      L_014
        mov     dword [rsp+28H], edx
        mov     ebx, 9
        mov     ebp, 10
L_004:  lea     edi, [r9+rbp+8H]
        movsxd  rdi, edi
        call    malloc
        movsxd  rsi, ebx
        mov     qword [rax], rbp
        mov     byte [rax+rbp+8H], 0
        movzx   edi, byte [rsp+rsi*4]
        lea     ecx, [rdi+30H]
        mov     byte [rax+rsi+8H], cl
        lea     ecx, [rbx-1H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-2H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-3H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-4H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-5H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-6H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-7H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   edi, byte [rsp+rcx*4]
        lea     esi, [rdi+30H]
        mov     byte [rax+rcx+8H], sil
        lea     ecx, [rbx-8H]
        cmp     ecx, -1
        je      L_001
        movsxd  rcx, ecx
        movzx   esi, byte [rsp+rcx*4]
        add     esi, 48
        cmp     ebx, 8
        mov     byte [rax+rcx+8H], sil
        je      L_001
        movzx   ebx, byte [rsp]
        lea     edx, [rbx+30H]
        mov     byte [rax+8H], dl
        jmp     L_001






ALIGN   16
L_005:  xor     r9d, r9d
        jmp     L_003





ALIGN   16
L_006:  xor     ebx, ebx
        mov     ebp, 1
        jmp     L_004





ALIGN   8
L_007:  mov     ebx, 1
        mov     ebp, 2
        jmp     L_004





ALIGN   8
L_008:  mov     ebx, 2
        mov     ebp, 3
        jmp     L_004





ALIGN   8
L_009:  mov     ebx, 3
        mov     ebp, 4
        jmp     L_004





ALIGN   8
L_010:  mov     ebx, 4
        mov     ebp, 5
        jmp     L_004





ALIGN   8
L_011:  mov     ebx, 5
        mov     ebp, 6
        jmp     L_004





ALIGN   8
L_012:  mov     ebx, 6
        mov     ebp, 7
        jmp     L_004





ALIGN   8
L_013:  mov     ebx, 7
        mov     ebp, 8
        jmp     L_004





ALIGN   8
L_014:  mov     ebx, 8
        mov     ebp, 9
        jmp     L_004

L_015:

        call    __stack_chk_fail



SECTION .data   


SECTION .bss    


SECTION .text.unlikely 


