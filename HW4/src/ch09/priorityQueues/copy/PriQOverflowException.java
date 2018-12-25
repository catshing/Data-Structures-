package ch09.priorityQueues.copy;

class PriQOverflowException extends RuntimeException
{
  public PriQOverflowException()
  {
    super();
  }

  public PriQOverflowException(String message)
  {
    super(message);
  }
}