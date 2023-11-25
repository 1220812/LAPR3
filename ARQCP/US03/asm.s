.section .data

.section .text

    .global move_num_vec
    # Arguments:
    # rdi -> int* array
    # rsi -> int length
    # rdx -> int* read
    # rcx -> int* write
    # r8  -> int num
    # r9  -> int* vec

move_num_vec:

    pushq %rbx
    pushq %rbp
    movq %rsp, %rbp

    cmpq %r8, %rbx            # Compare with the requested number to move
    jl not_enough_elements    # Jump if not enough elements

    movq %r9, %r11           # Store the destination address in %r11

    movq $0, %rax            # use %rax as a counter start it at 0

can_copy:
     movslq (%rdx, %rax, 4), %r9   # Move the 32-bit value to the destination

     cmpq $0, %r9               # Compare whats in %r9 with 0
     je reset_reader            # If equal jump to reset_reader

     movl $0, (%rdx, %rax, 4)   # Move 0 to the position in the first array to "delete" it
     movq %r9, (%r11)           # Move whats in %r9 to (%R11) to the new array

     addq $1, %rax             # add 1 to the counter
     addq $4, %r11             # adds 4 bits to the vec to pass to the next positon

     decq %r8                  # decrement num
     jz enough_elements        # if num = 0 jumps to enough_elements


     jmp can_copy              # jump to the loop again

reset_reader:
    subq $1, %rax              # Subtract 1 from %rax
    subl $1, %esi              # subtract 1 from %esi the length
    cmpl $0, %esi              # compare if length is 0
    je can_copy                # if it equals 0 jump to can_copy
    jmp reset_reader           # Jump again to reser_reader


enough_elements:
    movq $1, %rax                 # Set return value to 1
    jmp done                      # Jump to done

not_enough_elements:
    movq $0, %rax                 # Set return value to 0

done:
    popq %rbp                     # Restore registers
    popq %rbx                     # Restore old value %rdx

    ret                           # Return value
