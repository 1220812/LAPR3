.section .data

.section .text

    .global move_num_vec

move_num_vec:

    # Arguments:
    # rdi -> int* array
    # rsi -> int length
    # rdx -> int* read
    # rcx -> int* write
    # r8  -> int num
    # r9  -> int* vec

#--------------------Save registers-------------------------------------

    pushq %rbx          # Save current value of %rdx
    pushq %rbp          # Save current value of %rbp
    movq %rsp, %rbp

#-------------------Extract parameters----------------------------------

    movq %rdi, %rax     # array
    movq %rsi, %rbx     # length
    movq %rdx, %rcx     # read
    movq %rcx, %rdx     # Save read in rdx for later use
    movq %r8, %rsi      # num
    movq %r9, %rdi      # vec

#------------------Copy elements to the destination array-------------

    movq %rdi, %r11            # Store the destination address in a temporary register

    # Check if there are enough elements to move

    cmpq %rsi, %rbx            # Compare with the requested number to move


    jle not_n_elements_array    # JUMP IF NOT ENOUGH ELEMENTS

    subq %rcx, %rdx            # Calculate the number of elements in the buffer

copy_elements_loop:

    movslq (%rax, %rdx, 4), %rdi   # Move the 32-bit value to the destination
    movq %rdi, (%r11)              # Store the element in the destination array

    addq $1, %rdx                  # Move to the next position in the circular buffer
    addq $4, %r11                  # Move to the next position in the destination array

    decq %rsi                      # Decrement the counter for the number of elements to move

		#IF ALL ELEMENTS ARE MOVED
		jz n_elements             # JUMP TO ENOUGH_ELEMENTS

    cmpq %rdx, %rbx                # CHECK IF IS THE END OF THE CIRCULAR BUFFER

		#IF IS NOT THE END
		jge copy_elements_loop         # JUMP TO THE BEGINING (copy_elements_loop)

    subq %rdx, %rbx                # Adjust the remaining elements count



#----------------ENOUGH ELEMENTS IN ARRAY-------------------------------

n_elements:

    movq $1, %rax                 # Set return value to 1
    jmp final                      # Jump to done


#----------------NOT ENOUGH ELEMTS IN ARRAY-----------------------------

not_n_elements_array:
    movq $0, %rax                 # Set return value to 0


#-----------------------FINAL-------------------------------------------

final:
    popq %rbp                     # Restore old value of %rdp
    popq %rbx                     # Restore old value of %rdx
    ret                           # Return value
