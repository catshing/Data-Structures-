package ch09.priorityQueues.copy;

class PriQUnderflowException extends RuntimeException
{
  public PriQUnderflowException()
  {
    super();
  }

  public PriQUnderflowException(String message)
  {
    super(message);
  }
}